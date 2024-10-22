package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
        } catch (IOException e) {
            System.err.println("Input/output error: " + e.getMessage());
        }
        String[] numbers = text.toString().split(System.lineSeparator());
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                if (num % 2 == 0) {
                    System.out.println(num + " - even");
                } else {
                    System.out.println(num + " - not even");
                }
            } catch (NumberFormatException e) {
                System.err.println("Incorrect number: " + number);
            }
        }
    }
}
