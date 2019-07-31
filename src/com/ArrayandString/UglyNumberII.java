package com.ArrayandString;

/**
 * Write a program to find the n-th ugly number.
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
        if(n<=0) return 0;
        if(n==1)return 1;
        int t2=0,t3=0,t5=0;
        int []res=new int [n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=Math.min(res[t2]*2,Math.min(res[t3]*3,res[t5]*5));
            if(res[i]==res[t2]*2) t2++;
            if(res[i]==res[t3]*3) t3++;
            if(res[i]==res[t5]*5) t5++;

        }
        return res[n-1];
    }
}
