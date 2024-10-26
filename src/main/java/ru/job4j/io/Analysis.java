package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringJoiner;

public class Analysis {
    /**
     * Метод анализирует лог сервера и находит периоды недоступности.
     * Период недоступности определяется, если в логе встречается статус 400 или 500.
     * Конец периода фиксируется, когда статус меняется на 200 или 300.
     *
     * @param source путь к файлу с логами сервера (например, "data/server.log").
     * @param target путь к файлу для записи результата анализа (например, "data/target.csv").
     */
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileWriter(target))) {
            String line;
            boolean serverDown = false;
            String start = "";
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];
                if ((status.equals("400") || status.equals("500")) && !serverDown) {
                    start = time;
                    serverDown = true;
                } else if ((status.equals("200") || status.equals("300")) && serverDown) {
                    StringJoiner joiner = new StringJoiner(";", "", ";");
                    joiner.add(start).add(time);
                    out.println(joiner);
                    serverDown = false;
                }
            }
        } catch (IOException e) {
            System.err.println("Input-output error" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
