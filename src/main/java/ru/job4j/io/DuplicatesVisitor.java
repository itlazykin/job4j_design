package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Для вывода файлов в консоль.
 */
public class DuplicatesVisitor  extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> filesMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
        FileProperty property = new FileProperty(attributes.size(), file.getFileName().toString());
        filesMap.computeIfAbsent(property, k -> new ArrayList<>()).add(file);
        return FileVisitResult.CONTINUE;
    }

    public void printDuplicates() {
        filesMap.values().stream()
                .filter(paths -> paths.size() > 1)
                .forEach(paths -> {
                    System.out.println("Дубликаты:");
                    paths.forEach(System.out::println);
                });
    }
}
