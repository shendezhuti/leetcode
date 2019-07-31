package com.BinarySearch;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public  int[] searchRange(int[] nums, int target) {
        int hi = nums.length -1;
        int lo = 0;
        int[] result = new int[2];
        // base case
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1 };
        //left side
        while(lo < hi){
            int mid = lo + (hi - lo) /2;
            if(target > nums[mid]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        if(target == nums[lo]){
            result[0] = lo;
        }else{
            result[0] = -1;
        }

        //right side
        hi = nums.length-1 ;
        while(lo < hi){
            int mid = (lo + (hi - lo) /2 ) + 1;

            if(target < nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid;
            }
        }
        if(target == nums[hi]){
            result[1] = hi;
        }else{
            result[1] = -1;
        }

        return result;

    }

    public static void main(String[]args){
        FindFirstandLastPositionofElementinSortedArray test=new FindFirstandLastPositionofElementinSortedArray();
        int []nums={2,2};
        int []res=test.searchRange(nums,3);
        for(int num:res){
            System.out.println(num);
        }
    }
    }
