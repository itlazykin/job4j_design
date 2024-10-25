package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class DirectoryExample {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/main/java/ru/job4j/io/files/directory");
        /*
        Создает директорию, включая все промежуточные директории.
         */
        directory.mkdirs();
        File target = new File("src/main/java/ru/job4j/io/files");
        File fileOne = new File("src/main/java/ru/job4j/io/files/file1.txt");
        /*
         Создает новый файл.
         */
        fileOne.createNewFile();
        File fileTwo = new File("src/main/java/ru/job4j/io/files/directory/file2.txt");
        /*
         Создает новый файл.
         */
        fileTwo.createNewFile();
        /*
         Получаем имена файлов и директорий в target.
         */
        String[] list = target.list();
        for (String fileName : Objects.requireNonNull(list)) {
            System.out.println(fileName);
        }
        /*
         Получаем объекты File для файлов и директорий в target.
         */
        File[] listFiles = target.listFiles();
        for (File file : Objects.requireNonNull(listFiles)) {
            System.out.println(file);
        }
    }
}
