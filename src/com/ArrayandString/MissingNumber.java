package com.ArrayandString;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int expectedSum=nums.length*(nums.length+1)/2;
        int actualSum=0;
        for(int n:nums) actualSum+=n;
        return expectedSum-actualSum;
    }
}

