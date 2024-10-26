package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс {@code Search} предназначен для поиска файлов в указанной директории по определённому условию,
 * например, по расширению. Программа проходит по дереву файлов и выводит на консоль пути найденных файлов.
 */
public class Search {
    public static void main(String[] args) throws IOException {
        validArgs(args);
        Path start = Paths.get(args[0]);
        String extension = args[1];
        search(start, path -> path.toFile().getName().endsWith(extension)).forEach(System.out::println);
    }

    /**
     * Выполняет поиск файлов в дереве файлов, начиная с корневой директории,
     * с применением переданного условия.
     *
     * @param root      корневая директория, откуда начинается поиск
     * @param condition условие для фильтрации файлов (например, по расширению)
     * @return список путей найденных файлов, удовлетворяющих условию
     * @throws IOException если возникает ошибка ввода-вывода во время обхода файловой системы
     */
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * Проверяет корректность аргументов командной строки.
     * Ожидаются два аргумента: путь к директории и расширение файлов для поиска.
     *
     * @param args массив аргументов командной строки
     * @throws IllegalArgumentException если количество аргументов меньше двух,
     *                                  если аргументы пусты, если директория не существует
     *                                  или если расширение указано некорректно
     */
    public static void validArgs(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        String start = args[0];
        Path startFolder = Paths.get(start);
        if (!Files.isDirectory(startFolder) || !Files.exists(startFolder)) {
            throw new IllegalArgumentException(String.format("The file in directory \"%s\" not exist.", startFolder));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Not valid extension format. Extension must start with \".\"");
        }
    }
}
