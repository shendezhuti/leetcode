package com.ArrayandString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindAllNumberDissappearedInanArray {
    public List<Integer> findDissappearedNumber(int[]nums){
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int val=Math.abs(nums[i])-1;
            if(nums[val]>0){
                nums[val]=-nums[val];
            }

        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return  res;
    }

    public List<Integer> findDisappearedNumbersUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 0) return list;

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }

}
