package com.DFS;

import java.util.Arrays;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 *
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncresingPathinAMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0||matrix==null) return 0;
        int res=1;
        int m=matrix.length,n=matrix[0].length;
        int [][]cache=new int[m][n];
        int[]dir={0,1,0,-1,0};
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                res=Math.max(res,dfs(matrix,x,y,cache,dir));
            }

        }
        return res;
    }

    private int dfs(int [][]maxtrix,int x,int y,int [][]cache,int []dir){
        if(cache[x][y]!=0)return cache[x][y];
        cache[x][y]=1;
        for(int i=0;i<4;i++){
            int tx=x+dir[i];
            int ty=x+dir[i+1];
            if(tx<0||ty<0||tx>=maxtrix.length||ty>=maxtrix[0].length||maxtrix[tx][ty]<=maxtrix[x][y]){
                continue;
            }
            cache[x][y]=Math.max(cache[x][y],1+dfs(maxtrix,tx,ty,cache,dir));
        }
        return cache[x][y];
    }










    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPathc(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    public static void main(String[]args){
        LongestIncresingPathinAMatrix test=new LongestIncresingPathinAMatrix();
        int [][]matrix={{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(test.longestIncreasingPath(matrix));
        System.out.print(test.longestIncreasingPathc(matrix));
    }

    }
