package com.DynamicProgramming;

/**
 *Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n<=0)return 0;
        if(n==1)return 1;
        int []res=new int[n];
        res[0]=1;
        int n2=0,n3=0,n5=0;
        for(int i=1;i<n;i++){
            res[i]=Math.min(Math.min(res[n2]*2,res[n3]*3),res[n5]*5);
            if(res[i]==res[n2]*2)n2++;
            if(res[i]==res[n3]*3)n3++;
            if(res[i]==res[n5]*5)n5++;

        }
        return res[n-1];
    }
}
