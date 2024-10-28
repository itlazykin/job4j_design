package ru.job4j.encoding;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Консольный чат, который отвечает пользователю фразами из файла
 * и поддерживает команды управления: "стоп", "продолжить", "закончить".
 * <p>
 * Все диалоги записываются в лог-файл.
 */
public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> phrases = readPhrases();
        Scanner scanner = new Scanner(System.in);
        String action = CONTINUE;
        while (!action.equals(OUT)) {
            String request = scanner.nextLine();
            log.add(request);
            if (CONTINUE.equals(request)) {
                action = CONTINUE;
            } else if (STOP.equals(request)) {
                action = STOP;
            } else if (OUT.equals(request)) {
                action = OUT;
                log.add("");
                saveLog(log);
            }
            if (STOP.equals(action) || OUT.equals(action)) {
                continue;
            }
            String botResponse = phrases.get(new Random().nextInt(phrases.size()));
            log.add(botResponse);
            System.out.println(botResponse);
        }
    }

    private List<String> readPhrases() {
        List<String> result = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/chat.txt", "data/answer.txt");
        consoleChat.run();
    }
}
