package com.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 *Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 *
 *      0          3
 *
 *      |          |
 *
 *      1 --- 2    4
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 *
 * Example 2:
 *
 *      0           4
 *
 *      |           |
 *
 *      1 --- 2 --- 3
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 *
 *  Note:
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 *
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
                 List<List<Integer>> graph = new ArrayList<List<Integer>>();
                 for(int i = 0; i<n; i++){
                        graph.add(new ArrayList<Integer>());
                     }

                 for(int [] edge : edges){
                         graph.get(edge[0]).add(edge[1]);
                         graph.get(edge[1]).add(edge[0]);
                     }

               int []visited=new int[edges.length];
                int count = 0;
                 for(int i = 0; i<n; i++){
                         if(visited[i]==0){
                                 // bfs(graph, i, visited);
                                 dfs(graph, i, visited);
                                 count++;
                             }
                    }
               return count;
            }


            public void dfs( List<List<Integer>> graph,int cur,int []visited){
            if(visited[cur]==1)return ;

                for(int next:graph.get(cur)){
                    dfs(graph,next,visited);
                }
                visited[cur]=1;
            }
}
