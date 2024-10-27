package ru.job4j.regex.tregulove;

import java.util.regex.Pattern;

public class Regex6 {
    void checkIP(String ip) {
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}(25[0-5]|2[0-4]\\d |[01]?\\d?\\d)";
        System.out.println(ip + " it's ok? -" + Pattern.matches(regex, ip));
    }

    public static void main(String[] args) {
        String ip1 = "254.34.192.99";
        String ip2 = "255.256.11111.99";
        Regex6 regex6 = new Regex6();
        regex6.checkIP(ip1);
        regex6.checkIP(ip2);
    }
}
