package ru.job4j.algo.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 438. Find All Anagrams in a String
 */
public class FindAnagram {
    public static Set<Character> toSet(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * 1) Инициализация результата
     * 2) Создание множества символов из подстроки
     * 3) Определение размера окна
     * 4) Перебор подстрок в строке str. Здесь идет цикл, который проходит по строке str. На каждой итерации создается
     * подстрока window длиной windowSize, начиная с индекса i. Цикл продолжается, пока не достигнет конца строки str,
     * причем гарантируется, что есть достаточно символов для формирования окна заданного размера.
     * 5) Проверка на анаграмму. На каждой итерации проверяется, является ли текущее окно анаграммой подстроки substr.
     * Это делается путем сравнения множеств символов: если множество символов из window совпадает с множеством
     * символов из substr, то это означает, что текущее окно является анаграммой. Если да, то индекс начала окна (i)
     * добавляется в список result.
     * @param str строка.
     * @param substr подстрока.
     * @return анаграмму.
     */
    private static List<Integer> findAnagrams(String str, String substr) {
        var result = new ArrayList<Integer>();
        var anagrams = toSet(substr);
        int windowSize = substr.length();
        for (int i = 0; i < str.length() - windowSize; i++) {
            String window = str.substring(i, i + windowSize);
            if (anagrams.equals(toSet(window))) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println(anagramIndices);
    }
}
