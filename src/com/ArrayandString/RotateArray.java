package com.ArrayandString;

public class RotateArray {

    public int []rotate1(int []nums,int k){
        k%=nums.length;
        Reverse(nums,0,nums.length-1);
        Reverse(nums,0,k-1);
        Reverse(nums,k-1,nums.length-1);
        return nums;
    }
    public void Reverse(int[]nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


    public static void main(String []args){
        RotateArray test=new RotateArray();
        int []nums={1,2,3,4,5,6,7};
        int[]res=test.rotate1(nums,3);
        for(int n:res){
            System.out.print(n);
        }
    }
}
