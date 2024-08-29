package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListUpdate {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        result.add("one");
        result.add("two");
        result.add("three");
        /*
        E set(int index, E element) – заменяет элемент позиция которого равна index на элемент который мы передаем в
        метод (element). При этом метод возвращает старое значение элемента с индексом index.
         */
        result.set(0, "zero, one");
        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();
        /*
        default void replaceAll(UnaryOperator<E> operator) – заменяет каждый элемент в списке результатом применения
        оператора (operator) к каждому элементу.
         */
        result.replaceAll(String::toUpperCase);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
