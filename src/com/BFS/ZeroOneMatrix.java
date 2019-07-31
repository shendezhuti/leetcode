package com.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroOneMatrix {
    static  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return matrix;
        int m=matrix.length;
        int n=matrix[0].length;
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            int []cell=q.poll();
            for(int []dir:dirs){
                int x=cell[0]+dir[0];
                int y=cell[1]+dir[1];
                if(x<0||x>=m||y<0||y>=n||matrix[x][y]<=matrix[cell[0]][cell[1]]+1)continue;
                q.add(new int[]{x,y});
                matrix[x][y]=matrix[cell[0]][cell[1]]+1;
            }
        }
        return matrix;
    }
    }
