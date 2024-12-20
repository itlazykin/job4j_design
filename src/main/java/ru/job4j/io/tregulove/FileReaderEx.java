package ru.job4j.io.tregulove;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader("test1")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println("In/out error");
        }
    }
}