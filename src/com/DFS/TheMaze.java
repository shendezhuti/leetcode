package com.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 *
 * Example 1
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 *
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * Example 2
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 *
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination.
 * Note:
 *
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

 */
public class TheMaze {
    static int [][]dirs={{0,1},{0,-1},{-1,0},{1,0}};
    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0||maze[0].length==0||maze==null)return false;
        if(start[0]==destination[0]&&start[1]==destination[1])return true;
        int m=maze.length,  n=maze[0].length;
        boolean [][]visited=new boolean[m][n];
        return dfs(maze,start,destination,visited);
    }
    private boolean dfs(int [][]maze,int []cur,int []destination,boolean [][]visited){
        if(visited[cur[0]][cur[1]])return false;
        if(Arrays.equals(cur,destination))return true;

        visited[cur[0]][cur[1]]=true;
        for(int []dir:dirs){
            int x=cur[0]+dir[0];
            int y=cur[1]+dir[1];
          while(x>=0&&x<maze.length&&y>=0&&y<maze[0].length&&maze[x][y]!=1){
              x+=dir[0];
              y+=dir[1];
          }
            x -= dir[0]; y -= dir[1];
            if(dfs(maze,new int[]{x,y},destination,visited))return true;
        }
        return false;
    }

    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0||maze[0].length==0||maze==null)return false;
        if(start[0]==destination[0]&&start[1]==destination[1])return true;
        int m=maze.length,  n=maze[0].length;
        boolean [][]visited=new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]]=true;
        while(!q.isEmpty()){
            int []point=q.poll();
            int i=point[0],j=point[1];
            if(i==destination[0]&&j==destination[1])return true;
            for(int []dir:dirs){
                int x=i+dir[0];
                int y=j+dir[1];
                while(x>=0&&x<maze.length&&y>=0&&y<maze[0].length&&maze[x][y]!=1){
                    x+=dir[0];
                    y+=dir[1];
                }
                x-=dir[0];y-=dir[1];
                if(!visited[x][y]){
                    visited[x][y]=true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return false;
    }
}
