package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75F;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /**
     * Вычисляет хеш-код с учётом возможного переполнения (коллизий). Используется техника сдвига,
     * чтобы сделать хеш-код более равномерным.
     *
     * @param hashCode hashCode.
     * @return hashCode.
     */
    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode ^ (hashCode >>> 16));
    }

    /**
     * Вычисляет индекс массива для заданного хеша. Используется побитовое И с (table.length - 1),
     * что эффективно при условии, когда размер таблицы — степень двойки.
     *
     * @param hash hash.
     * @return индекс массива.
     */
    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    /**
     * Проверяет, совпадает ли ключ key с ключом в entry. Сравнение выполняется по хеш-коду и методу equals.
     *
     * @param entry ключ из MapEntry.
     * @param key   ключ, который проверяем.
     * @return true - когда совпадают.
     */
    private boolean checkKey(MapEntry<K, V> entry, K key) {
        boolean result = false;
        if (entry != null) {
            result = (Objects.hashCode(entry.key) == Objects.hashCode(key)) && Objects.equals(entry.key, key);
        }
        return result;
    }

    /**
     * Возвращает индекс для хранения ключа в таблице, используя методы hash и indexFor.
     *
     * @param key ключ.
     * @return индекс для хранения.
     */
    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    /**
     * Возвращает итератор для обхода ключей таблицы. Итератор проверяет, не изменилась ли структура таблицы с помощью
     * modCount. Если была модификация, то бросается исключение ConcurrentModificationException.
     *
     * @return итератор для обхода ключей таблицы.
     */
    @Override
    public Iterator<K> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length && table[index] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    /**
     * Добавляет элемент в таблицу. Если текущий коэффициент загрузки превышает LOAD_FACTOR, таблица расширяется.
     * Элемент добавляется только если в расчётной ячейке таблицы нет других элементов.
     *
     * @param key   ключ элемента.
     * @param value значение.
     * @return значение result, которое указывает, удалось ли вставить элемент (т.е. была ли ячейка пустой).
     * Если true, то вставка прошла успешно; если false, то элемент с таким ключом уже существовал и не был перезаписан.
     */
    @Override
    public boolean put(K key, V value) {
        if (LOAD_FACTOR * capacity <= count) {
            expand();
        }
        int index = getIndex(key);
        boolean result = table[index] == null;
        if (result) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return result;
    }

    /**
     * Получить объект по ключу.
     *
     * @param key ключ.
     * @return возвращает значение для указанного ключа, если такой ключ присутствует в таблице.
     */
    @Override
    public V get(K key) {
        int index = getIndex(key);
        V result = null;
        if (checkKey(table[index], key)) {
            result = table[index].value;
        }
        return result;
    }

    /**
     * Удаляет элемент по ключу, если он присутствует. Очищает ячейку и уменьшает счётчик элементов.
     *
     * @param key ключ.
     * @return значение result, которое указывает, удалось ли удалить элемент.
     */
    @Override
    public boolean remove(K key) {
        int index = getIndex(key);
        boolean result = false;
        if (checkKey(table[index], key)) {
            table[index] = null;
            modCount++;
            count--;
            result = true;
        }
        return result;
    }

    /**
     * Расширяет таблицу в два раза и перехеширует все элементы.
     * Перехеширование выполняется путём пересчёта индексов для каждого элемента в увеличенной таблице.
     */
    private void expand() {
        capacity *= 2;
        K key;
        V value;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                getIndex(entry.key);
                key = entry.key;
                value = entry.value;
                newTable[getIndex(key)] = new MapEntry<>(key, value);
                table = newTable;
            }
        }
    }

    /**
     * Этот класс представляет собой элемент таблицы, хранящий ключ и значение.
     *
     * @param <K>
     * @param <V>
     */
    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        NonCollisionMap<Integer, Integer> map = new NonCollisionMap<>();
        System.out.println(map.hash(0));
        System.out.println(map.hash(65535));
        System.out.println(map.hash(65537));
        System.out.println(map.indexFor(0));
        System.out.println(map.indexFor(7));
        System.out.println(map.indexFor(8));
    }
}
