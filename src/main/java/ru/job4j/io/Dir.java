package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    String.format("The directory does not exist: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("This is not a directory: %s", file.getAbsoluteFile()));
        }
        System.out.printf("Directory size: %s%n", file.getTotalSpace());
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            System.out.println(subfile.getAbsolutePath());
        }
        System.out.printf("File name - %s%n", file.getName());
        System.out.printf("File size - %s%n", file.length());
    }
}
