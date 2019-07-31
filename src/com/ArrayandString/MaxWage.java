package com.ArrayandString;

import java.util.Arrays;

/**
 * Max Wages
 *
 * You are a freelancer, there are n part-time jobs posted, you get paid by
 * completing the job, and you can choose many jobs to work on, the constraint
 * is you can not work on multiple jobs at the same time, you have to finish
 * a job then work on the next.
 *
 * Each job is represented as [start, end, wage].
 *
 * For example:
 * Input is [[0, 6, 8], [1, 4, 5], [3, 5, 1]]
 *
 * The jobs can be represented in the following graph:
 *
 * _____8_______
 *   ___5___
 *       __1__
 *
 * 0 1 2 3 4 5 6 7
 *
 * Your program should output 8. The maximum wages you can get should be $8,
 * that is only work on task 0.
 *
 * For example
 * Input is [[1,4,5],[3,5,1],[0,6,8],[4,7,4],[3,8,6],[5,9,3],[6,10,2],[8,11,4]]
 * Now you are given n tasks, find out the max wages you can get.
 */
public class MaxWage {
                           
    public int maxwage(int[][]jobs,int m){
        if(jobs==null|| jobs.length==0) return 0;
        //sort the jobs by the end time
        Arrays.sort(jobs[2]);
        int n= jobs.length;
        int [] dp=new int[n];
        int wagenotdo=0;
        int wagedo=0;
        //Initailize the dp
        dp[0]=jobs[0][2];
        for(int i=1;i<n;i++){
            //case 1. Do not take the current job
            wagenotdo=dp[i-1];
            //case 2 take the current job
            wagedo=jobs[i][2];
            // Add up the max wage from finishing previous jobs
            // make sure the jobs are not conflict
            for(int j=i-1;j>=0;j--){
                if(jobs[j][1]<=jobs[i][0]){
                    wagedo+=dp[j];
                    break;
                }
            }
            dp[i]=Math.max(wagenotdo,wagedo);
        }

        return dp[m-1];
    }

    public static void main(String []args) {
        MaxWage test = new MaxWage();
        int[][] jobs = {{1, 4, 5}, {3, 5, 1}, {0, 6, 8}, {4, 7, 4}, {3, 8, 6}, {5, 9, 3}, {6, 10, 2}, {8, 11, 4}};
        for(int i=1;i<=8;i++) {
            System.out.println("做"+i+"件事最优化的薪水价值是" + test.maxwage(jobs, i));
        }
    }
}
