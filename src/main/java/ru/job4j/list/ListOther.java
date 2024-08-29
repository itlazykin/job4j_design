package ru.job4j.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListOther {
    public static void main(String[] args) {
        /*
        Отмеченные (*) методы реализованы с помощью цикла for(), поэтому применять эти методы внутри циклов,
        которые перебирают список, нежелательно, поскольку так мы будем проходить по одному и тому же списку дважды.
         */
        List<String> result = new ArrayList<>();
        result.add("one");
        result.add("two");
        result.add("three");
        result.add("one");
        /*
        boolean contains*(E element) – метод возвращает true, если список содержит переданный в метод элемент element.
         */
        boolean check = result.contains("one");
        System.out.println(check);
        System.out.println();
        /*
        Int indexOf*(E element) – метод возвращает индекс элемента element при его первом вхождении в список.
        Если элемент не найден - метод возвращает -1.
         */
        int index = result.indexOf("three");
        System.out.println(index);
        System.out.println();
        /*
        Int lastIndexOf*(E element) - метод возвращает индекс элемента element при его последнем вхождении в список.
        Если элемент не найден - метод возвращает -1.
         */
        index = result.lastIndexOf("one");
        System.out.println(index);
        System.out.println();
        /*
        int size() - метод возвращает целочисленное значение, и говорит нам о том, сколько элементов находится в списке.
         */
        List<Integer> list = List.of(1, 2, 3);
        int size = list.size();
        System.out.println("Размер списка равен: " + size);
        System.out.println();
        /*
        List<E> subList(int fromIndex, int toIndex) - метод возвращает список, который содержит все элементы исходного
        списка начиная с индекса fromIndex(включительно) и до toIndex(значение исключается).
        При этом, если выполняется условие fromIndex == toIndex,- метод вернет пустой список.
         */
        List<String> subListDemo = result.subList(1, 2);
        for (String string : subListDemo) {
            System.out.println("Current elem: " + string);
        }
        System.out.println();
        /*
        default void sort(Comparator<? super E> comp) – метод осуществляет сортировку списка в соответствии с
        компаратором comp, который мы передаем в метод.
         */
        result.sort(Comparator.reverseOrder());
        for (String string : result) {
            System.out.println(string);
        }
    }
}
