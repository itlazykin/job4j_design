package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Класс {@code Zip} предоставляет функционал для упаковки файлов в архив формата ZIP.
 * Он позволяет упаковать один или несколько файлов, а также создать архив на основе
 * параметров, переданных через командную строку.
 */
public class Zip {
    /**
     * Упаковывает список файлов в указанный ZIP-архив.
     *
     * @param sources список файлов, которые нужно упаковать
     * @param target  файл-архив, в который будет произведена упаковка
     */
    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(String.valueOf(source)));
                try (BufferedInputStream output = new BufferedInputStream(
                        new FileInputStream(String.valueOf(source)))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Упаковывает один файл в указанный ZIP-архив.
     *
     * @param source файл, который нужно упаковать
     * @param target файл-архив, в который будет произведена упаковка
     */
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Выполняет проверку переданных аргументов командной строки.
     *
     * @param args объект {@code ArgsName}, содержащий аргументы
     * @throws IllegalArgumentException если аргументы не соответствуют требованиям
     */
    private static void validArgs(ArgsName args) {
        String directory = args.get("d");
        String exclude = args.get("e");
        String output = args.get("o");
        Path path = Paths.get(directory);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format("The path \"%s\" does not exist.", path));
        }
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException(String.format("The path \"%s\" exists but is not a directory.", path));
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("Not valid exclude format. Exclude must start with \".\"");
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException("Not valid extension format. The archive must have a '.zip' extension");
        }
        if (Files.exists(Paths.get(output))) {
            throw new IllegalArgumentException(String.format("The archive '%s' is already exists", output));
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        ArgsName argsName = ArgsName.of(args);
        validArgs(argsName);
        List<Path> sources = Search.search(Paths.get(argsName.get("d")),
                path -> !path.toFile().getName().endsWith(argsName.get("e")));
        packFiles(sources, Files.createFile(Paths.get(argsName.get("o"))).toFile());
    }
}