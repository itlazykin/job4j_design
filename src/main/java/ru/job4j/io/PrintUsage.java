package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 3. Классы вывода PrintStream / PrintWriter [#504999]
 */
public class PrintUsage {
    public static void main(String[] args) {
        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"));
             PrintWriter writer = new PrintWriter("data/write.txt")) {
            stream.println("From PrintStream to FileOutputStream");
            stream.write("New string".getBytes());
            writer.println("New message");
        } catch (IOException e) {
            System.err.println("Input/output error: " + e.getMessage());
        }
    }
}
