package com.DFS;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * Accepted
 * 327,643
 * Submissions
 * 801,606
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0||grid==null)return 0;
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;i<m;j++){
                if(grid[i][j]=='1'){
                    DFSMarking(grid,i,j);
                    count++;
                }
            }
        }
        return count;

    }

    private void DFSMarking(char[][] grid, int n, int m) {
        if(n<0||n>=grid.length||m<0||m>=grid[0].length)return ;
        grid[n][m]='0';
        DFSMarking(grid,n+1,m);
        DFSMarking(grid,n-1,m);
        DFSMarking(grid,n,m+1);
        DFSMarking(grid,n,m-1);

    }
    }
