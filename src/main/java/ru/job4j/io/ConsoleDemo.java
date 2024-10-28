package ru.job4j.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleDemo {
    public static void main(String[] args) {
        String login;
        char[] charPassword;
        /*
        Получаем объект консоли и проверяем, что он присутствует.
        Если объекта нет (null), то с помощью оператора return выходим из метода,
        так как больше в этом методе делать нечего, если нет объекта.
        Данная проверка обязательна, так как программа может быть запущена из разных мест,
        соответственно, нужно удостовериться, что из этого места есть доступ к консоли (командной строке).
         */
        Console console = System.console();
        if (console == null) {
            System.out.println("Консоль недоступна");
            return;
        }
        /*
        С помощью метода readLine() мы принимаем строку от пользователя.
         */
        login = console.readLine("%s", "Введите логин: ");
        console.printf("Ваш логин: %s\n", login);
        /*
        Запрашиваем и сохраняем у пользователя пароль.
         */
        charPassword = console.readPassword("%s", "Введите пароль: ");
        System.out.println("Ваш пароль: " + String.valueOf(charPassword));
        /*
        Метод fill() затирает все данные в массиве пробелами
         */
        Arrays.fill(charPassword, ' ');
    }
}

