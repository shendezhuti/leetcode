package com.DFS;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircle {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 1) continue;
            dfs(M, visited, i);
            count++;
        }

        return count;
    }

    public void dfs(int [][]M,int []visited,int cur){
        if(visited[cur]==1)return;
        visited[cur]=1;
        //visit all friends(neighbors 这里是其余所有的同学)
        for(int j=0;j<M.length;j++){
            if(M[cur][j]==1&&visited[j]==0){
                dfs(M,visited,j);
            }
        }
    }

    public int findCircleNumUF(int[][] M) {
        int n=M.length;
        UnionFindSet uf=new UnionFindSet(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(M[i][j]==1)uf.Union(i,j);
            }
        }
        return uf.count();
    }
}
