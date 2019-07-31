package com.DynamicProgramming;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<=0||n<=0 )return 0;
        int [][]res=new int[m+1][n+1];
        res[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1)continue;
                else{
                    res[i][j]=res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[m][n];
    }

    public int uniquePathsImprove(int m,int n){
        if(m<0||n<0)return 0;
        int []dp=new int [n+1];
        dp[1]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(i==1&&j==1)continue;
                else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }

    /**
     * 以下这种方法是错的，因为有两层循环，不可能只用两个变量而做到
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsImproveII(int m,int n){
        if(m<0||n<0)return 0;
        int pre=0, cur=1;
        for(int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if(i==1&&j==1)continue;
                else{
                    cur+=pre;
                    pre=cur;
                }
            }
        }
        return cur;
    }
    }
