package com.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 * Note:
 *
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 */
public class ShortestBridge {
    static int [][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestBridge(int[][] A) {
        int m=A.length, n=A[0].length;
        boolean [][]visited=new boolean [m][n];
        boolean found=false;
        Queue<int []>q=new LinkedList<>();
        // 1. dfs to find an island, mark it in `visited`
        for(int i=0;i<m;i++){
            if(found)break;
            for(int j=0;j<n;j++){
                if(A[i][j]==1){
                    dfs(A,visited,q,i,j);
                    found=true;
                    break;
                }
            }
        }
        // 2. bfs to expand this island
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []cur=q.poll();
                for(int []dir:dirs){
                    int x=cur[0]+dir[0];
                    int y=cur[1]+dir[1];
                    if(x>=0&&y>=0&&x<m&&y<n&&!visited[x][y]){
                        if(A[x][y]==1)return steps;
                        q.offer(new int[]{x,y});
                        visited[x][y]=true;
                    }
                }

            }
            steps++;
        }
        return -1;
    }
    private  void dfs(int [][]A, boolean [][]visited,Queue<int []> q,int i,int j){
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) return;
        visited[i][j]=true;
        q.offer(new int[]{i,j});
        for(int []dir:dirs){
            dfs(A,visited,q,i+dir[0],j+dir[1]);
        }
    }
    }
