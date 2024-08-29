package ru.job4j.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * Мы можем задавать тип generics, а можем ли мы его прочитать и узнать?
 * Такая возможность есть - даже несмотря на то, что это используется довольно редко, но об этом знать необходимо.
 * Существует только одна ситуация, когда универсальный тип доступен во время выполнения -
 * это когда универсальный тип является частью сигнатуры класса подобным образом:
 */
public class FloatList extends ArrayList<Float> {
    /**
     * Мы можем узнать актуальный параметр generic-класса, если этот параметр был задан явным образом
     * (т.е. параметр определен внутри секции extends одного из наследников).
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Float> listOfNumbers = new FloatList();
        Class actual = listOfNumbers.getClass();
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter);
    }
}
