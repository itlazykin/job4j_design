package ru.job4j.algo;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * Решение получше :
 * public int[] sortedSquares(int[] nums) {
 *     final int[] res = new int[nums.length];
 *     int left = 0;
 *     int right = nums.Length - 1;
 *     int index = nums.Length - 1;
 *      Сравнение квадратов элементов с обоих концов массива
 *     while (left <= right) {
 *         int numLeft = nums[left] * nums[left];
 *         int numRight = nums[right] * nums[right];
 *          Вставка большего квадрата в текущую позицию с конца
 *         if (numLeft > numRight) {
 *             res[index--] = numLeft;
 *             left++;
 *         } else {
 *             res[index--] = numRight;
 *             right--;
 *         }
 *     }
 *     return res;
 * }
 */
public class SolutionTwoPointer {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int resultIndex = n - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[resultIndex] = nums[left] * nums[left];
                left++;
            } else {
                result[resultIndex] = nums[right] * nums[right];
                right--;
            }
            resultIndex--;
            Arrays.sort(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {-7, -3, 2, 3, 11};
        int[] resultArray = sortedSquares(sortedArray);
        System.out.println(Arrays.toString(resultArray));
    }
}

