package com.DynamicProgramming;

/**
 *
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int end=0;
        int maxpostion=0;
        int steps=0;
        for(int i=0;i<nums.length-1;i++){
            maxpostion=Math.max(i+nums[i],maxpostion);

            if(i==end){
                end=maxpostion;
                steps++;
            }
        }
        return steps;


    }


    }
