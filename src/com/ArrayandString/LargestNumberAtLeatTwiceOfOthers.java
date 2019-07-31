package com.ArrayandString;

public class LargestNumberAtLeatTwiceOfOthers {

    public int dominantIndex(int []nums){
        int max1=0,max2=0,maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                int temp=max1;
                max1=nums[i];
                max2=temp;
                maxIndex=i;
            }else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        return max1>=2*max2 ? maxIndex:-1;
    }

    public static void main(String[]agrs) {
        LargestNumberAtLeatTwiceOfOthers test = new LargestNumberAtLeatTwiceOfOthers();
        int[] nums = {3, 6, 1, 0};
        System.out.print(test.dominantIndex(nums));
    }
}
