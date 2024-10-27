package ru.job4j.io.tregulove.lead;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationExLead {
    public static void main(String[] args) {
        List<String> employees;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("employees.bin"))) {
            employees = (ArrayList) input.readObject();
            System.out.println(employees);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
