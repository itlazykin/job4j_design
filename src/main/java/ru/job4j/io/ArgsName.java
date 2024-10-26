package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс {@code ArgsName} предоставляет функционал для парсинга аргументов командной строки
 * в формате {@code -ключ=значение}. Он позволяет удобно получать значения по переданным ключам.
 */
public class ArgsName {
    /**
     * Хранит пары ключ-значение, полученные из аргументов командной строки.
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * Возвращает значение, соответствующее переданному ключу.
     *
     * @param key ключ, по которому нужно получить значение
     * @return значение, соответствующее указанному ключу
     * @throws IllegalArgumentException если ключ отсутствует в аргументах
     */
    public String get(String key) {
        String value = values.get(key);
        if (value == null) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return value;
    }

    /**
     * Парсит массив аргументов командной строки и сохраняет их в виде пар ключ-значение.
     * <p>
     * Требования к аргументам:
     * <ul>
     *     <li>Аргумент должен начинаться с символа {@code -}.</li>
     *     <li>Аргумент должен содержать символ {@code =} для разделения ключа и значения.</li>
     *     <li>Ключ и значение не могут быть пустыми или состоять только из пробелов.</li>
     * </ul>
     *
     * @param args массив аргументов командной строки
     * @throws IllegalArgumentException если аргумент не соответствует указанным требованиям
     */
    private void parse(String[] args) {
        for (String arg : args) {
            validateArgument(arg);
            String[] parts = arg.substring(1).split("=", 2);
            values.put(parts[0], parts[1]);
        }
    }

    /**
     * Создает экземпляр {@code ArgsName} и выполняет парсинг переданных аргументов.
     *
     * @param args массив аргументов командной строки
     * @return объект {@code ArgsName} с проанализированными аргументами
     * @throws IllegalArgumentException если аргументы не были переданы
     */
    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    /**
     * Выполняет валидацию аргумента командной строки.
     *
     * @param arg аргумент для проверки
     * @throws IllegalArgumentException если аргумент не соответствует требованиям
     */
    private void validateArgument(String arg) {
        if (!arg.startsWith("-")) {
            throw new IllegalArgumentException(
                    "Error: This argument '" + arg + "' does not start with a '-' character");
        }
        if (!arg.contains("=")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain an equal sign");
        }
        String[] parts = arg.substring(1).split("=", 2);
        if (parts[0].isBlank()) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a key");
        }
        if (parts[1].isBlank()) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a value");
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}