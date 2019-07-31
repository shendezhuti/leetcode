package com.ArrayandString;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
    int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        sums = new int[nums.length];
        // accumulate the sum from nums[0] to nums[i]
        for (int i = 0; i < nums.length; i++)
            sums[i] = nums[i] + (i > 0 ? sums[i - 1] : 0);
    }

    public int sumRange(int i, int j) {
        return (i == 0) ? sums[j] : sums[j] - sums[i - 1];
    }
}

