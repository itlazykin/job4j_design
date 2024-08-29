package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListAdd {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        List<String> list = new ArrayList<>();
        /*
         * boolean add(E e) – добавляет элемент e в конец списка.
         */
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        /*
          Void add(int index, E element) – добавляет указанный элемент (element) в указанную позицию(index) в списке.
          При этом сдвигает элемент, который находится в этой позиции(если есть), и все последующие элементы вправо.
         */
        rsl.add(1, "four");
        list.add("four");
        list.add("five");
        /*
        boolean addAll(Collection<? extends E> c) – добавляет все элементы из переданной коллекции в конец списка
        в том порядке, в котором они возвращаются итератором переданной коллекции.
         */
        rsl.addAll(list);
        /*
        Boolean addAll(int index, Collection<? Extends E> c) – добавляет все элементы из коллекции C в список в
        указанную позицию(index). При этом сдвигает элемент, который находится в этой позиции,
        и все последующие элементы вправо. Добавляемые элементы будут расставлены в том порядке,
         в котором они возвращены итератором переданной коллекции.
         */
        rsl.addAll(2, list);
        for (String string : rsl) {
            System.out.println("Current elem: " + string);
        }
        /*
        List<E> of(E ... elements) - метод возвращает список, в которые помещены список элементов elements типа E.
        Как мы видим метод принимает переменное количество аргументов (обозначается ...).
        Т.е. мы можем перечислять большое количество аргументов через запятую. Метод возвращает неизменяемый список,
        т.е. вызвать метод add(), remove() и т.п. на такой коллекции не получится, будет сгенерировано исключение
         UnsupportedOperationException.
         */
        List<String> result = List.of("one", "two", "three");
        for (String string : result) {
            System.out.println("Current element: " + string);
        }
    }
}
