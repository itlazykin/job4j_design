package ru.job4j.scanner.tregulove;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/*
В сканер можно передавать файлы.
 */
public class Scanner1 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        try (Scanner scanner = new Scanner(new FileReader("text.txt"))) {
            scanner.useDelimiter("\\W");
            while (scanner.hasNext()) {
                String word = scanner.next();
                set.add(word);
            }
            for (String word : set) {
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
