package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;

public class PathExample {
    public static void main(String[] args) throws IOException {
        try {
            Path directory = Paths.get("path/paths");
            Files.createDirectories(directory);
            Path target = Paths.get("path");
            Path pathOne = Path.of("path/paths/path1.txt");
            Files.createFile(pathOne);
            Path pathTwo = Path.of("path/path2.txt");
            Files.createFile(pathTwo);
            DirectoryStream<Path> paths = Files.newDirectoryStream(target);
            paths.forEach(System.out::println);
        } catch (DirectoryNotEmptyException e) {
            System.err.println("DirectoryNotEmptyException " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.err.println("The file or directory already exists" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Input/output error" + e.getMessage());
        }
    }
}

