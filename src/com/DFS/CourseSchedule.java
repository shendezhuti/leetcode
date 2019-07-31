package com.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 *There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int course=prerequisites[i][0];
            int pre=prerequisites[i][1];
            graph.get(course).add(pre);
        }
        // 0:not visited 1:visiting 2:visited
        int []visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(i,graph,visited)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int cur, List<List<Integer>>graph,int []visited){
        if(visited[cur]==1)return true;
        if(visited[cur]==2)return false;
        visited[cur]=1;
        for(int next:graph.get(cur)){
            if(dfs(next,graph,visited))return true;
        }
        visited[cur]=2;
        return  false;
    }
}
