package ru.job4j.io.tregulove;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExBinary {
    public static void main(String[] args) {
        try (FileInputStream input =
                     new FileInputStream("C:\\Users\\itlaz\\OneDrive\\Рабочий стол\\download.jpg");
             FileOutputStream output = new FileOutputStream("download.jpg")) {
            int i;
            while ((i = input.read()) != -1) {
                output.write(i);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
