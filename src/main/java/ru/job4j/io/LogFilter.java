package ru.job4j.io;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    /**
     * Фильтрует записи из указанного лог-файла, возвращая только те строки,
     * в которых предпоследнее значение равно "404".
     * <p>
     * Метод читает файл с помощью {@link BufferedReader} и обрабатывает каждую строку
     * в виде потока. Если предпоследний элемент в строке (разделённой пробелами) равен "404",
     * строка включается в результат.
     * </p>
     *
     * @return {@link List} строк, содержащий только те строки, где предпоследнее значение — "404".
     * Если при чтении файла возникнет ошибка ввода-вывода, возвращается пустой список.
     * @throws RuntimeException В случае ошибки ввода-вывода выводится сообщение об ошибке
     *                          в стандартный поток ошибок.
     */
    public List<String> filter() {
        List<String> filter = Collections.emptyList();
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            filter = input.lines().filter(string -> {
                        String[] all = string.split(" ");
                        return "404".equals(all[all.length - 2]);
                    })
                    .toList();
        } catch (IOException e) {
            System.err.println("Input/output error" + e.getMessage());
        }
        return filter;
    }

    /**
     * Сохраняет отфильтрованные строки из лог-файла в указанный выходной файл.
     * <p>
     * Метод сначала вызывает {@link #filter()}, чтобы получить список строк,
     * в которых предпоследнее значение равно "404". Затем он записывает эти строки
     * в указанный файл с использованием {@link PrintWriter}.
     * Если при записи возникает ошибка ввода-вывода, она обрабатывается, и
     * выводится сообщение об ошибке в стандартный поток ошибок.
     * </p>
     *
     * @param out путь к выходному файлу, в который будут записаны отфильтрованные строки.
     *            Если файл не существует, он будет создан автоматически.
     * @throws RuntimeException если возникнет ошибка ввода-вывода при записи в файл.
     */
    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)))) {
            data.forEach(output::println);
        } catch (IOException e) {
            System.err.println("Input/output error" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.saveTo("data/404.txt");
    }
}
