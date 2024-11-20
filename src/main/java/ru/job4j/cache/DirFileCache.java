package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Класс {@code DirFileCache} реализует кеширование файлов в указанной директории.
 * Наследуется от абстрактного класса {@link AbstractCache} и переопределяет метод
 * {@link AbstractCache#load(Object)} для загрузки содержимого файла по ключу.
 *
 * <p>Класс использует директорию для кеширования файлов и их содержимое, считывая файлы как строки
 * в кодировке UTF-8.</p>
 */
public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String content = null;
        try {
            content = Files.readString(Paths.get(cachingDir, key), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла: " + e.getMessage());
        }
        return content;
    }
}