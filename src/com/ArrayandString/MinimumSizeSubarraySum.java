package com.ArrayandString;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s,int[]nums){
        int start=0,end=0,sum=0,minlen=Integer.MAX_VALUE;
        while(end<nums.length){
            while(end<nums.length&&sum<s){
            sum+=nums[end++];
            }
            while(start<nums.length&&sum>=s){
               sum-=nums[start++];
               if(end-start+1<minlen){
                   minlen=end-start+1;
               }
            }
        }

        return minlen==Integer.MAX_VALUE ? 0:minlen;
    }
    public static void main(String []args){
        MinimumSizeSubarraySum test=new MinimumSizeSubarraySum();
        int []nums={2,3,1,2,4,3};
        System.out.print(test.minSubArrayLen(7,nums));

    }
}
