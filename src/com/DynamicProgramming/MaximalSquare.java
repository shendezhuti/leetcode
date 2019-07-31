package com.DynamicProgramming;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0||matrix==null)return 0;
        int [][]dp=new int [matrix.length+1][matrix[0].length+1];
        int res=0;
        for(int i=1;i<=matrix.length;i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res*res;

    }
        public int maximalSquareII ( char[][] matrix){
            if (matrix.length == 0 || matrix == null) return 0;

            int[] curr = new int[matrix[0].length + 1];
            int upperLeft = 0;
            int res = 0;
            int temp = 0;
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    temp = curr[j];
                    if (matrix[i - 1][j - 1] == '1') {
                        curr[j] = Math.min(Math.min(curr[j - 1], upperLeft), curr[j]) + 1;
                        res = Math.max(res, curr[j]);
                    } else
                        curr[j] = 0;
                    upperLeft = temp;

                }
            }
            return res * res;
        }

        public static void main (String[]args){
            char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
            MaximalSquare test = new MaximalSquare();
            System.out.println(test.maximalSquare(matrix));
            System.out.println(test.maximalSquareII(matrix));

        }
    }
