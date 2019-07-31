package com.ArrayandString;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrixII {
    public int [][]generatemartix(int n){
        //declaration
        int[][]matrix=new int[n][n];
        if(n==0){
            return matrix;
        }
        int top=0;
        int down=n-1;
        int left=0;
        int right=n-1;
        int num=1;
        while(top<=down&&left<=right){
            for(int i=left;i<=right;i++){
                matrix[top][i]=num++;
            }
            top++;
            for(int i=top;i<=down;i++){
                matrix[i][right]=num++;
            }
            right--;

            for(int i=right;i>=left;i--){
                if(left<=right){
                    matrix[down][i]=num++;
                }
            }
            down--;

            for(int i=down;i>=top;i--){
                if(top<=down){
                    matrix[i][left]=num++;
                }
            }
            left++;
        }
        return matrix;

    }
    public static void main(String[]args){
        GenerateMatrixII test=new GenerateMatrixII();
        int [][]res=test.generatemartix(3);
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(res[i][j]);
            }
        }

    }
}
