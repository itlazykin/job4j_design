package ru.job4j.regex.tregulove;

import java.util.Arrays;

public class Regex1 {
    public static void main(String[] args) {
        String s = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48, email: vivanov@mail.ru,"
                + " Postcode: AA99, Phone number: +123456789;  "
                + "Petrov Sergey, Ukraine, Kivy, Lomonosova street, 32, Flat 11, email: petrov@ya.ru, "
                + "Postcode: UKR84, Phone number: +545134234; "
                + "Chuck Norris, USE, Holywood, All star street, 69, Flat 21, email: che@gmail.com\" "
                + "Postcode: USA23, Phone number: +4134135312;";
        String s1 = "che@hmail.com";
        boolean rsl = s1.matches("\\w+@\\w+\\.(com|ru)");
        System.out.println(rsl);

        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
    }
}
