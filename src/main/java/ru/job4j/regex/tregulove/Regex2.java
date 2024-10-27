package ru.job4j.regex.tregulove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
        String s = "ABCD ABCE ABCFABCGABCH";
        Pattern pattern = Pattern.compile("ABCD");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
