package com.ArrayandString;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int [][] obstacleGrid){
        int width=obstacleGrid[0].length;
        int []way=new int[width];
        way[0]=1;
        for(int []row:obstacleGrid){
            for(int j=0;j<width;j++){
                if(row[j]==1){
                    way[j]=0;
                }else if(j>0){
                    way[j]+=way[j-1];
                }
            }
        }
        return way[width-1];
    }

    public static void main (String []args){
        UniquePathII test=new UniquePathII();
        int count=1;
        int [][]grid={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("输入的矩阵情况是：");
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(count<grid[0].length) {
                    System.out.print(grid[i][j]);
                }else {
                    System.out.println(grid[i][j]);
                    count=0;
                }
                count++;
            }
        }
        System.out.println("一共的情况数目为："+test.uniquePathsWithObstacles(grid));
    }
}
