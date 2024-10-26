package ru.job4j.io.tregulove;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String rubai = """
                Можно соблазнить мужчину, у которого есть жена.
                Можно соблазнить мужчину, у которого есть любовница.
                Но нельзя соблазнить мужчину,
                У которого есть любимая женщина.
                """;
        try (FileWriter writer = new FileWriter("test1")) {
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println("In/out error" + e.getMessage());
        }
    }
}
