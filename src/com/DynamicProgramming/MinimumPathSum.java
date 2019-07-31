package com.DynamicProgramming;

/**
 *Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        if(m<0||n<0) return 0;

        int []dp=new int [n];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(i==0&&j>0) dp[j]=dp[j-1]+grid[i][j];
                else if(i>0&&j==0)dp [j]=dp[j]+grid[i+1][j];
                else if(i>0&&j>0)dp[j]=Math.min(dp[j],dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];

    }
    }
