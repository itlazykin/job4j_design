package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListRead {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        result.add("one");
        result.add("two");
        result.add("three");
        /*
        E get(int index) – метод возвращает элемент, который находится в позиции index в этом списке.
        Метод может кинуть исключение класса IndexOutOfBoundsException,
        если будет выполнено условие index < 0 || index > size().
         */
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Текущий элемент: " + result.get(i));
        }
        System.out.println();
        /*
        Iterator<E> iterator() – метод возвращает объект Iterator, который содержит в себе все элементы исходной
        коллекции.
         */
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }
        /*
        Для того чтобы получить экземпляр итератора в интерфейсе List<E> определены 3 метода:
        Iterator<E> iterator() – метод возвращает объект Iterator, который содержит в себе все элементы исходной
        коллекции.
         */
        System.out.println();
        ListIterator<String> listIterator = result.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Текущий элемент: " + listIterator.next());
        }
        System.out.println();
        /*
          ListIterator<E> listIterator(int index) – возвращает итератор списка для элементов в этом списке, начиная с
          элемента индекс которого равен index.
         */
        ListIterator<String> listIteratorIndex = result.listIterator(2);
        while (listIteratorIndex.hasNext()) {
            System.out.println("Текущий элемент: " + listIteratorIndex.next());
        }
        System.out.println();
    }
}
