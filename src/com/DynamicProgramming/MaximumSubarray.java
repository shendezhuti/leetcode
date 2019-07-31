package com.DynamicProgramming;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)return 0;
      int n=nums.length;
      int dp[]=new int[n];
      dp[0]=nums[0];
      int max=dp[0];
      for(int i=1;i<nums.length;i++){
          dp[i]=nums[i]+ dp[i-1]>0? dp[i-1]:0;
          max=Math.max(dp[i],max);
      }
      return max;
    }


    public int maxSubArrayII(int []nums){
        if (nums.length==0||nums==null)return 0;
        int max=nums[0], sum=nums[0];
        for(int i:nums){
            if(sum<0) {sum=nums[i];}
            else {sum+=nums[i];}
            max=Math.max(max,sum);
        }
        return max;
    }
}
