package com.ArrayandString;

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
    public int uniquePath(int m,int n){
        if(m<0||n<0)return 0;
        int [][]res=new int[m+1][n+1];
        if(m==1&&n==1) return 1;
        if(res[m][n]>0)return res[m][n];

        int left_path=uniquePath(m-1,n);
        int top_path=uniquePath(m,n-1);
        res[m][n]=left_path+top_path;
        return res[m][n];
    }

    public int uniquePathDP(int m,int n){
        if(m<0||n<0)return 0;
        int [][]res=new int[m+1][n+1];
        res[1][1]=1;
        for(int y=1;y<=n;y++){
            for(int x=1;x<=m;x++){
                if(x==1&&y==1) continue;
                else{
                    res[x][y]=res[x-1][y]+res[x][y-1];
                }
            }
        }
        return res[m][n];
    }
    public int uniquePathsImprove(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];

    }
    public static void main(String []args){
        UniquePaths test=new UniquePaths();
      //  int m=7;
       // int n=3;
        for(int m=1;m<=6;m++){
            for(int n=1;n<=3;n++){
                System.out.println("输入的网格为m= " +m+ " * n=" +n+" 所有的情况数目为"+test.uniquePathsImprove(m,n));

            }
        }
    }

}
