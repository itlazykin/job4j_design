package ru.job4j.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStream {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{'j', 'a', 'v', 'a'};
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        int data;
        while ((data = stream.read()) != -1) {
            System.out.println((char) data);
        }
        System.out.println();
        String string = "123456789";
        byte[] stringByte = string.getBytes();
        ByteArrayInputStream strStream = new ByteArrayInputStream(stringByte, 3, 4);
        int strData;
        while ((strData = strStream.read()) != -1) {
            System.out.println((char) strData);
        }
        System.out.println();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] outBytes = "Message".getBytes();
        outputStream.writeBytes(outBytes);
        System.out.println(outputStream);
        System.out.println();
        try (FileOutputStream fileOutputStream = new FileOutputStream("data/message.txt")) {
            outputStream.writeTo(fileOutputStream);
        } catch (IOException e) {
            System.err.println("input/output error" + e.getMessage());
        }
    }
}
