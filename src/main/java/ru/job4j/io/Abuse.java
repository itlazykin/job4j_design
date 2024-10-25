package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class Abuse {
    /**
     * Удаляет из исходного файла указанные слова и сохраняет результат в целевой файл.
     *
     * <p>
     * Метод читает строки из исходного файла, разбивает их на слова,
     * отфильтровывает указанные в списке `words` слова и записывает результат
     * в целевой файл. Каждое слово разделяется пробелом. Используется
     * автоматическое закрытие ресурсов (try-with-resources).
     * </p>
     *
     * @param source путь к исходному файлу, из которого читаются данные
     * @param target путь к целевому файлу, в который будет записан результат
     * @param words  список слов, которые необходимо удалить из текста
     * @throws IOException если возникают ошибки ввода-вывода при работе с файлами
     */
    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader input = new BufferedReader(new FileReader(source));
             PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            input.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(output::print);
        }
    }
}
