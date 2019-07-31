package com.Math;

/**
 *Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n){
        int count=0;
        while(n!=0){
            int temp=n/5;
            count+=temp;
            n=temp;
        }
        return count;
    }

    /**
     * 下面这个解法是不行的，因为num会超出范围
     * @param n
     * @return
     */
    public int trailingZeroesmyway(int n){
        int count=0;
        long num=1;
        while(n!=0){
            num=n*num;
            n--;
        }
        while(num!=0){
             long temp=num;
             num/=10;
            if(num*10!=temp){return count;}
                count++;
        }
        return count;
    }

    public static void main(String []args){
        FactorialTrailingZeroes test=new FactorialTrailingZeroes();
        System.out.print(test.trailingZeroesmyway(13));
    }
}
