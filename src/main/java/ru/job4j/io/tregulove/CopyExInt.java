package ru.job4j.io.tregulove;

import java.io.*;

/**
 * Читаем данные посимвольно.
 */
public class CopyExInt {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("test2.txt"));
             BufferedWriter writer = new BufferedWriter(new PrintWriter("test3.txt"))
        ) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
