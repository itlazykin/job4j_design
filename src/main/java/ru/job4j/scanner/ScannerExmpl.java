package ru.job4j.scanner;

import java.io.*;
import java.util.Scanner;

/*
Прочитать числа в шестнадцатеричном виде и вывести в десятичном
 */
public class ScannerExmpl {
    public static void main(String[] args) throws Exception {
        var data = "A 1B FF 110";
        var file = File.createTempFile("data", null);
        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file))) {
            output.write(data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (var scanner = new Scanner(file).useRadix(16)) {
            while (scanner.hasNextInt()) {
                System.out.print(scanner.nextInt());
                System.out.print(" ");
            }
        }
    }
}
