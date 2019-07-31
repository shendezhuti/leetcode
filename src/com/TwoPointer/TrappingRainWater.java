package com.TwoPointer;

/***
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height==null||height.length<3)return 0;
        int i=0;
        int j=height.length-1;
        int leftmax=0;
        int rightmax=0;
        int res=0;
        while(i<=j){
            leftmax=Math.max(leftmax,height[i]);
            rightmax=Math.max(rightmax,height[j]);
            if(leftmax<rightmax){
                res+=leftmax-height[i];
                i++;
            }else{
                res+=rightmax-height[j];
                j--;
            }
        }
        return res;
    }
}
