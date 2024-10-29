package ru.job4j.io;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.*;

/**
 * Класс {@code CSVReader} предназначен для чтения и фильтрации данных из CSV-файла на основе заданных параметров.
 *
 * <p>Программа ожидает следующие аргументы:</p>
 * <ul>
 *     <li>{@code path} — путь к файлу CSV.</li>
 *     <li>{@code delimiter} — разделитель, используемый в CSV (например, запятая или точка с запятой).</li>
 *     <li>{@code out} — путь к файлу для сохранения результата или {@code stdout} для вывода в консоль.</li>
 *     <li>{@code filter} — список колонок, которые необходимо отфильтровать.</li>
 * </ul>
 *
 * <p>Пример использования:</p>
 * <pre>{@code
 * java CSVReader path=data.csv delimiter=, out=stdout filter=name,age
 * }</pre>
 *
 * <p>Класс обеспечивает валидацию аргументов, чтение данных, фильтрацию по указанным колонкам
 * и запись результата в указанный файл или вывод в консоль.</p>
 */
public class CSVReader {
    public static final String PATH = "path";
    public static final String DELIMITER = "delimiter";
    public static final String OUT = "out";
    public static final String FILTER = "filter";

    /**
     * Метод обрабатывает аргументы и выполняет чтение, фильтрацию и запись данных.
     *
     * @param argsName объект {@code ArgsName}, содержащий аргументы командной строки.
     * @throws IOException если возникла ошибка при чтении или записи файла.
     */
    public static void handle(ArgsName argsName) throws IOException {
        List<String> filterArgs = new ArrayList<>();
        var scanner = new Scanner(
                new CharArrayReader(argsName.get(FILTER).toCharArray())).useDelimiter("[ *, *]");
        while (scanner.hasNext()) {
            filterArgs.add(scanner.next());
        }
        List<String> allRows = new ArrayList<>();
        try (var reader = new Scanner(new BufferedReader(new FileReader(argsName.get(PATH))))) {
            while (reader.hasNext()) {
                allRows.add(reader.nextLine());
            }
        }
        List<String> filteredRows = filter(allRows, filterArgs, argsName.get(DELIMITER));
        Files.write(Path.of(argsName.get(OUT)), filteredRows);
    }

    /**
     * Фильтрует строки CSV-файла на основе указанных колонок.
     *
     * @param allRows    все строки из CSV-файла.
     * @param filterArgs список колонок для фильтрации.
     * @param delimiter  разделитель, используемый в CSV.
     * @return список отфильтрованных строк.
     */
    private static List<String> filter(List<String> allRows, List<String> filterArgs, String delimiter) {
        List<String> columnsName = parseString(allRows.get(0), delimiter);
        List<Integer> indexes = findColumns(columnsName, filterArgs);
        List<String> filteredRows = new ArrayList<>();
        for (String row : allRows) {
            List<String> parseRow = parseString(row, delimiter);
            StringJoiner current = new StringJoiner(delimiter);
            for (int index : indexes) {
                current.add(parseRow.get(index));
            }
            filteredRows.add(String.valueOf(current));
        }
        return filteredRows;
    }

    /**
     * Находит индексы колонок, которые должны быть отфильтрованы.
     *
     * @param columnsName список всех колонок.
     * @param filterArgs  список колонок для фильтрации.
     * @return список индексов выбранных колонок.
     */
    private static List<Integer> findColumns(List<String> columnsName, List<String> filterArgs) {
        List<Integer> indexes = new ArrayList<>();
        for (String filter : filterArgs) {
            int i = columnsName.indexOf(filter);
            if (i != -1) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /**
     * Парсит строку CSV в список значений с учетом разделителя.
     *
     * @param row       строка CSV.
     * @param delimiter разделитель.
     * @return список значений строки.
     */
    private static List<String> parseString(String row, String delimiter) {
        List<String> result = new ArrayList<>();
        var scanner = new Scanner(new CharArrayReader(row.toCharArray())).useDelimiter(delimiter);
        while (scanner.hasNext()) {
            String current = scanner.next();
            StringBuilder builder = new StringBuilder(current);
            String temp = current.trim();
            if (!temp.isEmpty()) {
                if (temp.startsWith("<<")) {
                    while (!temp.endsWith(">>") && scanner.hasNext()) {
                        String next = scanner.next();
                        temp = next.trim();
                        builder.append(delimiter);
                        builder.append(next);
                    }
                }
            }
            result.add(String.valueOf(builder));
        }
        return result;
    }

    /**
     * Выполняет валидацию аргументов, переданных программе.
     *
     * @param argsName объект {@code ArgsName}, содержащий аргументы командной строки.
     * @throws IllegalArgumentException если один из аргументов недействителен.
     */
    public static void validArgsToReader(ArgsName argsName) {
        String input = argsName.get(PATH);
        Path inputPath = Path.of(input);
        if (!Files.exists(inputPath)) {
            throw new IllegalArgumentException(String.format("The path \"%s\" does not exist.", inputPath));
        }
        if (Files.isDirectory(inputPath)) {
            throw new IllegalArgumentException(String.format("The path \"%s\" is a directory.", inputPath));
        }
        String filter = argsName.get(FILTER);
        if (filter.isBlank()) {
            throw new IllegalArgumentException(String.format("%s can not be empty.", FILTER));
        }
        String out = argsName.get(OUT);
        if (!out.equals("stdout")) {
            try {
                Path.of(out);
            } catch (InvalidPathException e) {
                throw new InvalidPathException(String.format(
                        "%s argument should be 'stdout' or valid path to this OC. ", OUT), e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        validArgsToReader(argsName);
        handle(argsName);
    }
}
