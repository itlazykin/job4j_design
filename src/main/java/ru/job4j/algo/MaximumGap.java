package ru.job4j.algo;

import java.util.Arrays;

/**
 * 164. Maximum Gap
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
}
