package ru.job4j.io.tregulove.programmer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEmployee {
    public static void main(String[] args) {
        Car car = new Car("Nissan", "White");
        Employee employee = new Employee("Den", "Lazykin", "IT", 35, 420, car);
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("employees2.bin"))) {
            output.writeObject(employee);
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
