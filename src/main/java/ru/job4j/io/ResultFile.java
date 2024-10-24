package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultFile {
    public static void main(String[] args) {
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("data/dataResult.txt")))) {
            output.println("Hello world!");
        } catch (IOException e) {
            System.err.println("Input/output error" + e.getMessage());
        }
    }
}

