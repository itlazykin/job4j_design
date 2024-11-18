package ru.job4j.memory;

public class Example {
    public static void main(String[] args) {
        int x = 0;
        Object o = new Object();
        Example example = new Example();
        example.action(o);
    }

    private void action(Object parameter) {
        String s = parameter.toString();
        System.out.println(s);
    }
}
