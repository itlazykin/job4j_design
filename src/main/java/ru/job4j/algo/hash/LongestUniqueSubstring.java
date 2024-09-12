package ru.job4j.algo.hash;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestUniqueSubstring {
    public static Set<Character> toSet(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Находит самую длинную подстроку состоящую из уникальных элементов.
     *
     * @param str строка.
     * @return самую длинную подстроку.
     */
    public static String longestUniqueSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        var uniqueElements = toSet(str);
        var setLength = uniqueElements.size();
        for (int i = setLength; i >= 1; i--) {
            for (int j = 0; j <= str.length() - i; j++) {
                String window = str.substring(j, j + i);
                if (window.length() == toSet(window).size()) {
                    return window;
                }
            }
        }
        return "";
    }
}
