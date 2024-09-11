package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int[] result = null;
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[right - 1] == nums[right]) {
                left = right;
                right = left + 1;
            }
            if (right - left + 1 == k) {
                result = new int[2];
                result[0] = left;
                result[1] = right;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
