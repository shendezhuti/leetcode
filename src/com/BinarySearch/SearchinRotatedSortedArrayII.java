package com.BinarySearch;

/**
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int mid=(lo+hi)>>>1;
            if(target==nums[mid]) return true;
            //左半段有序
            if(nums[lo]<nums[mid]){
                //target在这段
                if(target>=nums[lo]&&target<nums[mid]){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }

            }else if(nums[lo]>nums[mid]){
                //右半段有序
                if(target>nums[mid]&&target<=nums[hi]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }else{

                lo++;
            }
        }
        return false;

    }


}
