package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AbuseTest {

    @Test
    /*
      аннотация @TempDir указывает, что папка Path tempDir будет временной:
     */
    void drop(@TempDir Path tempDir) throws IOException {
        /*
        создаем файл и заполняем его содержимое:
         */
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("hello foolish dude");
            output.println("java job4j php");
        }
        /*
        создаем файл, куда будет выведен результат
         */
        File target = tempDir.resolve("target.txt").toFile();
        /*
        выполняем действие программы и читаем полученный результат из файла target
         */
        Abuse.drop(source.getAbsolutePath(), target.getAbsolutePath(), List.of("foolish", "php"));
        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        /*
        проверяем результаты
         */
        assertThat("hello dude java job4j ").hasToString(result.toString());
    }
}