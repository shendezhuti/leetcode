package com.DynamicProgramming;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int row=matrix.length;
        int col=matrix[0].length;
        int []heights=new int [col];
        int maxarea=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]== '1'){
                    heights[j]=1;
                }else{
                    heights[j]=0;
                }
            }
            int temparea=largestRectangleAreaUsingStack(heights);
            maxarea=Math.max(maxarea,temparea);
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
