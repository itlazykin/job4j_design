package ru.job4j.algo.sort;

import java.util.Arrays;

public class Quick {
    /**
     * Метод запускает процесс сортировки массива, вызывает приватную версию метода.
     *
     * @param sequence массив для сортировки.
     */
    public static void quickSort(int[] sequence) {
        quickSort(sequence, 0, sequence.length - 1);
    }

    /**
     * Метод рекурсивно разбивает массив на части и сортирует каждую часть.
     *
     * @param sequence массив для сортировки.
     * @param start    начальный элемент массива.
     * @param end      конечный элемент массива.
     */
    private static void quickSort(int[] sequence, int start, int end) {
        if (start >= end) {
            return;
        }
        int h = breakPartition(sequence, start, end);
        quickSort(sequence, start, h - 1);
        quickSort(sequence, h + 1, end);
    }

    /**
     * Метод делит массив на две части относительно "опорного элемента" (первый элемент массива — sequence[start])
     *
     * @param sequence массив для сортировки.
     * @param start    начальный элемент массива.
     * @param end      конечный элемент массива.
     * @return Возвращает индекс, где оказался опорный элемент.
     */
    private static int breakPartition(int[] sequence, int start, int end) {
        int beginToEnd = start + 1;
        int supportElement = sequence[start];
        int endToBegin = end;
        while (true) {
            while (beginToEnd < end && sequence[beginToEnd] < supportElement) {
                beginToEnd++;
            }
            while (sequence[endToBegin] > supportElement) {
                endToBegin--;
            }
            if (beginToEnd >= endToBegin) {
                break;
            }
            swap(sequence, beginToEnd++, endToBegin--);
        }
        swap(sequence, start, endToBegin);
        return endToBegin;
    }

    /**
     * Метод меняет два элемента массива местами.
     *
     * @param array массив.
     * @param i     для хранения значения элемента с индексом i.
     * @param j     для хранения значения элемента с индексом j.
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 5, -2, 7, 3, -2};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
