package com.DynamicProgramming;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if(heights.length==0||heights==null)return 0;
        int maxarea=0;

        for(int cur=0;cur<heights.length;cur++){
            if(cur==heights.length-1||heights[cur]>heights[cur+1]){
                int minheight=heights[cur];
                for(int i=cur;i>=0;i++){
                    minheight=Math.min(minheight,heights[i]);
                    maxarea=Math.max(maxarea,(cur-i+1)*minheight);
                }
            }
        }
        return maxarea;
    }


    public int largestRectangleAreaUsingStack(int []heights){
        int len=heights.length;
        int maxarea=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<=len;){
            int h=(i==len?0:heights[i]);
            if(stack.isEmpty()||h>=heights[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int curHeight=heights[stack.pop()];
                int rightBoundary=i-1;
                int leftBounrady=stack.isEmpty()? 0:stack.peek()+1;
                int width=rightBoundary-leftBounrady+1;
                maxarea=Math.max(maxarea,width*curHeight);
            }
        }
        return maxarea;
    }
    }
