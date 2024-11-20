package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс {@code AbstractCache} представляет собой базовую структуру кеша,
 * использующего {@link SoftReference} для хранения значений.
 *
 * <p>Этот класс реализует основные операции работы с кешем, такие как добавление данных в кеш
 * и их извлечение с автоматической загрузкой в случае отсутствия значения в кеша.</p>
 *
 * @param <K> тип ключа
 * @param <V> тип значения
 */
public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public final V get(K key) {
        V value = null;
        SoftReference<V> reference = cache.get(key);
        if (reference != null) {
            value = reference.get();
        }
        if (value == null) {
            value = load(key);
            if (value != null) {
                put(key, value);
            }
        }
        return value;
    }

    protected abstract V load(K key);
}
