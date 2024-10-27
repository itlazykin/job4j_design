package ru.job4j.io.tregulove.programmer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationProgrammerEx {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Den");
        employees.add("Nas");
        employees.add("Ler");
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("employees.bin"))) {
            output.writeObject(employees);
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
