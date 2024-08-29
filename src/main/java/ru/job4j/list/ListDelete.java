package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListDelete {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        result.add("one");
        result.add("two");
        result.add("three");
        /*
        E remove(int index) – удаляет элемент из списка по индексу index, при этом метод возвращает удаленный элемент.
         */
        result.remove(0);
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();
        /*
        boolean remove(E e) – удаляет элемент е типа E из коллекции при его ПЕРВОМ вхождении в список,
        если он есть в коллекции. Реализован с помощью цикла for(), подразумевает под собой первоначальный поиск
        удаляемого элемента и только потом он удаляется. Соответственно, использование этого метода внутри цикла,
        который перебирает список, не рекомендуется, поскольку мы будем проходить по списку дважды.
         */
        result.add("one");
        result.remove("two");
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();
        /*
        boolean removeAll(Collection<?> col) – метод удаляет из списка все элементы, которые содержатся в
        коллекции col, если в результате работы метода исходный список изменился - метод возвращает true.
         */
        result.add("two");
        result.removeAll(list);
        for (String string : result) {
            System.out.println(string);
        }
        result.add("one");
        result.add("two");
        result.add("three");
        /*
        Boolean retainAll(Collection<?> col) – метод также удаляет элементы из списка, за исключением тех,
        которые находятся в коллекции col, если в результате работы метода исходный список изменился -
        метод возвращает true. В результате в списке останутся только те значения, которые содержатся в списке result.
         */
        list.retainAll(result);
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println();
        /*
        Default boolean removeIf(Predicate<? super E> filter) – метод удаляет все элементы из коллекции, которые
        удовлетворяют условию определенному в предикате filter(передается в виде лямбда выражения).
        Если в результате работы метода список изменился - метод возвращает true.
         */
        result.removeIf(string -> string.length() <= 3);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
