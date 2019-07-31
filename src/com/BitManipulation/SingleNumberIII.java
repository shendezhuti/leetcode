package com.BitManipulation;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * https://segmentfault.com/a/1190000004886431
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int AXORB = 0;
        for (int num : nums) {
            AXORB ^= num;
        }
        // pick one bit as flag
        int bitFlag = (AXORB & (~ (AXORB - 1))); //这一行代码是算法的核心
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & bitFlag) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
