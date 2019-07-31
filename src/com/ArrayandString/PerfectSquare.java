package com.ArrayandString;

import java.util.*;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquare {

    public int numSquareBFS(int n){
        Queue <Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        q.offer(0);
        visited.add(0);
        int depth=0;
        while(!q.isEmpty()){
            int size=q.size();
            depth++;
            while(size-->0){
               int u=q.poll();
               for(int i=1;i*i<=n;i++){
                   int v=u+i*i;
                   if(v==n){
                       return  depth;
                   }
                   if(v>n){
                       break;
                   }
                   if(!visited.contains(v)){
                       q.offer(v);
                       visited.add(v);
                   }
               }
            }
        }
        return depth;
    }

    public int numSqureDP(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String []args){}

}
