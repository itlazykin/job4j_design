package ru.job4j.algo;

/**
 * 136. Single Number
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int rsl = 0;
        for (int n : nums) {
            rsl ^= n;
        }
        return rsl;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1, 2};
        int rsl = singleNumber(numbers);
        System.out.println(rsl);
    }
}
