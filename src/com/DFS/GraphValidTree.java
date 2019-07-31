package com.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * For example:
 *
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * Hint:
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class GraphValidTree {
    public boolean canValid(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int course=prerequisites[i][0];
            int pre=prerequisites[i][1];
            graph.get(course).add(pre);
        }
        int []visited=new int[numCourses];

            if(dfs(0, -1,graph,visited)){
                return false;
        }
          for(int i=0;i<visited.length;i++){
              if (visited[i]==0)return false;
          }
        return true;
    }
    private boolean dfs(int cur,int pre, List<List<Integer>>graph,int []visited){
        if(visited[cur]==1)return true;
        if(visited[cur]==2)return false;
        visited[cur]=1;
        for(int next:graph.get(cur)){
            if(dfs(next,cur,graph,visited))return true;
        }
        visited[cur]=2;
        return  false;
    }

}
