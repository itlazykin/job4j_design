package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Читает файл и заполняет values парами ключ-значение
     */
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            Map<String, String> properties = reader
                    .lines()
                    .map(String::trim)
                    .filter(line -> !line.isBlank())
                    .filter(line -> !(line.charAt(0) == '#'))
                    .filter(this::valid)
                    .collect(Collectors.toMap(
                            line -> line.substring(0, line.indexOf('=')).trim(),
                            line -> line.substring(line.indexOf('=') + 1).trim(),
                            (existing, replacement) -> replacement));
            values.putAll(properties);
        } catch (IOException e) {
            System.err.println("Input/output error" + e.getMessage());
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    private boolean valid(String line) {
        int indexEquals = line.indexOf('=');
        if (indexEquals == 0
                || indexEquals == line.length() - 1
                || indexEquals == -1) {
            StringJoiner message = new StringJoiner(" ",
                    "Please check each line ",
                    "of the file for the key=value pattern.");
            message.add(path);
            throw new IllegalArgumentException(message.toString());
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            System.err.println("Input/output error");
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
