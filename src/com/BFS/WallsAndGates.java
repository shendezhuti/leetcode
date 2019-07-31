package com.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class WallsAndGates {
    public void wallsAndGatesDFS(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }


    }

    public void dfs(int[][] rooms, int i, int j, int d) {
        if (i < 0 || i >= rooms.length || j < 0 || j > rooms[0].length || rooms[i][j] < d) return;
        rooms[i][j] = d;
        dfs(rooms, i - 1, j, d + 1);
        dfs(rooms, i, j - 1, d + 1);
        dfs(rooms, i + 1, j, d + 1);
        dfs(rooms, i, j + 1, d + 1);
    }

    public void wallsAndGatesBFS(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; i < rooms.length; j++) {
                if (rooms[i][j] == 0) q.add(new int[]{i, j});
            }

        }
        while (!q.isEmpty()) {
            int[] gate = q.poll();
            int i = gate[0];
            int j = gate[1];
            for (int k = 0; i < dirs.length; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][0];
                if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[i][j] > rooms[x][y]+1) continue;
                rooms[x][y] = rooms[i][j] + 1;
                q.add(new int[]{x, y});
            }
        }
    }
}
