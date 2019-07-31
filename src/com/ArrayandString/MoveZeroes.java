package com.ArrayandString;

public class MoveZeroes {

    public int[]res(int []nums){
        if(nums==null||nums.length==0)return null;
        int index=0;
        for(int n:nums){
            if(n!=0) nums[index++]=n;
        }
        while(index<nums.length){
            nums[index++]=0;
        }
        return nums;
    }

    public static void main(String []args){
        MoveZeroes test=new MoveZeroes();
        int []nums={0,1,0,3,12};
        int []res=test.res(nums);
        for(int n:res){
            System.out.print(n);
        }
    }
}
