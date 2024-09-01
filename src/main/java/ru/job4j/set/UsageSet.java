package ru.job4j.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        System.out.println("Добавление элементов в множество.");
        /*
         * boolean add(E e) – добавляет элемент в множество и при этом возвращает true только в том случае,
         если такого элемента еще нет в наборе данных. Если уже такой элемент имеется в коллекции - метод вернет
         false и набор данных при этом не изменится. Равенство объектов определяется по методу equals()
         */
        strings.add("one");
        strings.add("two");
        strings.add("three");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        /*
         * Boolean addAll(Collection<? extends E> c) - добавляет все элементы из переданной коллекции в множество,
         если они еще не присутствуют в данном множестве. Если передаваемая коллекция также является множеством,
         то применение данного метода является эффективным способом объединения двух множеств.
         */
        strings.addAll(List.of("one", "four", "five"));
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        /*
         * Set<E> of(E ... elements) - метод возвращает множество, в которое помещены список элементов elements типа E.
          Как мы видим, метод принимает переменное количество аргументов (обозначается ...), что означает,
          что мы можем перечислять большое количество аргументов через запятую.
          Метод возвращает неизменяемое множество, т.е. вызвать метод add(), remove() и т.п.
          на таком наборе не получится, будет сгенерировано исключение UnsupportedOperationException.
         */
        Set<String> set = Set.of("one", "two", "three");
        for (String string : set) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("Чтение элементов из множества.");
        /*
         * В интерфейсе Set не определено методов get() для получения элементов из множества. Единственным способом
         получения элементов из набора данных является использование итератора.
         Iterator<E> iterator() – метод возвращает итератор по элементам во множестве. При этом элементы возвращаются в
         произвольном порядке (если только в качестве реализации интерфейса Set не используется тип коллекции,
         которая гарантирует определенный порядок).
         */
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println("Current elem: " + iterator.next());
        }
        System.out.println();
        System.out.println("Изменение элементов в множестве.");
        /*
         * Для данной структуры данных не определено методов которые напрямую позволяют изменить элементы в множестве.
         Но в данном случае можно пойти на хитрость и использовать связку методов - remove() и add().
         Т.е. мы сначала удаляем элемент, который надо заменить. Потом добавляем элемент, которым надо его заменить.
         */
        System.out.println();
        System.out.println("Удаление элементов из множества.");
        /*
         * boolean remove(E e) - удаляет указанный элемент из множества, если он присутствует в нем.
         Метод возвращает true, если в результате вызова метода набор данных изменился,
         т.е. если в результате он был удален.
         */
        strings.remove("two");
        System.out.println("Console output after delete");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        /*
         * Boolean removeAll(Collection<?> c) - удаляет из множества все элементы, которые содержатся в переданной в
         метод коллекции. Метод возвращает true, если в результате работы метода исходное множество изменилось.
         */
        strings.removeAll(List.of("two", "three"));
        System.out.println("Console output after delete");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        /*
         * Boolean retainAll(Collection<?> c) - в результате работы метода во множестве сохраняются только те элементы,
         которые содержатся в передаваемой в метод коллекции. Если в результате работы метода исходное множество было
         изменено - метод вернет true.
         */
        strings.retainAll(List.of("one"));
        System.out.println("Console output after delete");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        /*
         * Default boolean removeIf(Predicate<? super E> filter) - метод удаляет все элементы из коллекции, которые
         удовлетворяют условию определенному в предикате filter(передается в виде лямбда выражения).
         Если в результате работы метода множество изменилось - метод возвращает true.
         */
        strings.add("two");
        strings.add("three");
        strings.removeIf(string -> string.startsWith("t"));
        System.out.println("Console output after delete");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("Важные методы интерфейса");
        /*
         * boolean contains(E e) – метод возвращает true, если множество содержит переданный в метод элемент e.
         Сравнение объектов выполняется с помощью метода equals().
         */
        boolean rsl = strings.contains("two");
        System.out.println(rsl);
        System.out.println();
        /*
        int size() - метод возвращает целочисленное значение, и говорит нам о том, сколько элементов содержит множество.
         */
        int size = strings.size();
        System.out.println(size);
        System.out.println();
        /*
         * default Stream<E> stream() - метод возвращает последовательный поток Stream, источником которой является
         наше множество. Далее этот поток мы обрабатываем методами которые определены в интерфейсе Stream.
         */
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        strings.add("six");
        strings.stream()
                .filter(string -> string.length() > 2)
                .forEach(string -> System.out.println("Current elem: " + string));
    }
}
