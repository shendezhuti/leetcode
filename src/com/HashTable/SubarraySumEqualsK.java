package com.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int presum=0,result=0;
        Map<Integer,Integer> hm= new HashMap<Integer,Integer>();
        hm.put(0,1);

        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            if(hm.containsKey(presum-k)){
                result+=hm.get(presum-k);
            }
            hm.put(presum,hm.getOrDefault(presum,0)+1);
        }
        return result;
    }


    public int subarraySumNavie(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for(int index=i;index<=j;index++){
                    sum+=nums[index];
                }
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumPredix(int []nums,int k){
        int count=0;
        for(int i=0;i<nums.length;i++){
            int prefixsum=0;
            for(int j=i;j<nums.length;i++){
                prefixsum+=nums[j];
                if(prefixsum==k){
                    count++;
                }
            }
        }
        return count;
    }
}