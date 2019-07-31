package com.DFS;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            helper(matrix, dir, pac, i, 0);
            helper(matrix, dir, atl, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            helper(matrix, dir, pac, 0, i);
            helper(matrix, dir, atl, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) res.add(new int[]{i, j});
            }
        }
        return res;
    }

    void helper(int[][] matrix, int[][] dir, boolean[][] isVisited, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        isVisited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= m || y >= n || isVisited[x][y] || matrix[i][j] > matrix[x][y]) {
                continue;
            }
            helper(matrix, dir, isVisited, x, y);
        }
    }
}
