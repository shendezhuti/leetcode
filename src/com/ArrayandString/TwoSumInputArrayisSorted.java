package com.ArrayandString;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1,index2 = 2.
 */
public class TwoSumInputArrayisSorted {
    public int [] twosum(int []nums,int target){
        int []result=new int [2];
        if(nums.length<2) return result;
        int left=0,right=nums.length-1;
        int v;
        while(left<right){
            v=nums[left]+nums[right];
            if(v==target){
                result[0]=left+1;
                result[1]=right+1;
                break;
            }else if(v<target){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[]args){
        TwoSumInputArrayisSorted test=new TwoSumInputArrayisSorted();
        int []nums={2,7,11,15};
        int []result=test.twosum(nums,9);
        for(int n:result) {
            System.out.println(n);
        }

    }
}
