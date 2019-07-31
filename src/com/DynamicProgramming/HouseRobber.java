package com.DynamicProgramming;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
    public int robrecursive(int []nums){
        return helper1(nums,nums.length-1);
    }

    public int helper1(int []nums,int i){
        if(i<0){
            return 0;
        }
        return Math.max(helper1(nums,i-2)+nums[i],helper1(nums,i-1));
    }
    int []memo;
    public int robrecursivememo(int[]nums){
        memo =new int[nums.length+1];
        Arrays.fill(memo,-1);
        return helper2(nums,nums.length-1);
    }

    public int helper2 (int []nums,int i){
        if(i<0)return 0;
        if(memo[i]>=0)return memo[i];
        int result=Math.max(helper2(nums,i-2)+nums[i],helper2(nums,i+1));
        memo[i]=result;
        return result;
    }

    public int robiterative(int []nums){
        if(nums.length==0)return 0;
        int[]memo=new int[nums.length+1];
        memo[0]=0;
        memo[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            int val=nums[i];
            memo[i+1]=Math.max(memo[i],memo[i-1]+val);
        }
        return memo[nums.length];
    }

    public int robiterativeimprove(int []nums){
        if(nums.length==0)return 0;
        int prev1=0,prev2=0;
        for(int num:nums){
            int temp=prev1;
            prev1=Math.max(prev2+num,prev1);
            prev2=temp;
        }
        return prev1;
    }
}
