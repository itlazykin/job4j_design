package ru.job4j.io.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStream {
    public static void main(String[] args) {
        Car car = new Car("Фирма", "Модель", 2000);
        /*
        Мы открываем поток записи объектов out и с помощью метода writeObject() происходит запись объекта в файл
        в байтовом представлении. Если мы попытаемся прочитать файл, то увидим в нём непонятный набор символов,
        так как данные там хранятся в байтовом виде.
         */
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/serialized.dat"));
             /*
             открыли поток чтения объекта
              */
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/serialized.dat"))) {
            out.writeObject(car);
            /*
            произведём десериализацию этого объекта
             */
            Car deserialized = (Car) in.readObject();
            System.out.println(deserialized.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
