package com.ArrayandString;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns),
 return all elements of the matrix in spiral order.

 Example 1:
 Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

 Example 1:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][]matrix) {
        List<Integer> res = new ArrayList<>();
        int down = matrix.length-1;
        if(down<=0) return res;
        int right=matrix[0].length-1;
        int top=0,left=0;

        while(left<=right&&top<=down){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);

            }
            top++;
            for(int i=top;i<=down;i++){
                res.add(matrix[i][right]);
            }
            right--;

            if(down-top>=0){
                for(int i=right;i>=left;i--){
                    res.add(matrix[down][i]);
                }
                down--;

            }
            if(right-left>=0){
                for(int i=down;i>=top;i--){
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }

        return res;
    }

    public static void  main(String[]args){
        SpiralMatrix test=new SpiralMatrix();

        int [][]matrix={{1, 2, 3,4 },{ 5, 6, 7,8 },{ 9, 10, 11,12} };

        List<Integer> list=test.spiralOrder(matrix);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
