package ru.job4j.algo.sorted;

import java.util.Arrays;

/**
 * Элементы последовательно сравниваются и меняются местами, пока не будут упорядоченны.
 * Худший случай - О(n)^2.
 * Средний случай - О(n)^2.
 * Лучший случай - О(n) (Если массив отсортирован)
 */
public class BubbleSort {
    public static int[] swap(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {-1, 43, 13, 98, -15, 156, 32, 11, 91, 100, 300, 843};
        System.out.println(Arrays.toString(swap(array)));
    }
}
