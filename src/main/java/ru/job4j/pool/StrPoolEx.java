package ru.job4j.pool;

public class StrPoolEx {
    public static void main(String[] args) {
        System.out.println(new String("New string") == new String("New string"));
        System.out.println(
                new String("Interned string").intern() == new String("Interned string").intern());
    }
}
