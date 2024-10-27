package ru.job4j.io.tregulove.lead;

import ru.job4j.io.tregulove.programmer.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationExEmployee {
    public static void main(String[] args) {
        Employee topEmployee;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("employees2.bin"))) {
            topEmployee = (Employee) input.readObject();
            System.out.println(topEmployee);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
