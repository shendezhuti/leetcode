package com.BitManipulation;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 * Accepted
 * 222,528
 * Submissions
 * 531,961
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt == 1;
    }
    public boolean isPowerOfTwoTrick(int n) {

        return (n>0&&(n&(n-1))==0);
    }

    public static void main(String []args){
        int n=2;
        System.out.print(n&(n-1));
    }
}
