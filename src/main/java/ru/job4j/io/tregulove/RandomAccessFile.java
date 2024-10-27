package ru.job4j.io.tregulove;

import java.io.IOException;

public class RandomAccessFile {
    public static void main(String[] args) {
        try (java.io.RandomAccessFile file = new java.io.RandomAccessFile("test10.txt", "rw")) {
            int pointer = file.read();
            System.out.println((char) pointer);
            String string = file.readLine();
            System.out.println(string);
            /*
            Устанавливает pointer туда, куда нам нужно.
             */
            file.seek(11);
            String string1 = file.readLine();
            System.out.println(string1);
            file.seek(0);
            file.writeBytes("smile");
            System.out.println((char) pointer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
