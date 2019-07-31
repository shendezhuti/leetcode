package com.ArrayandString;

public class DiagonalTraverse {

    public int [] findDiagonalOrder(int [][]matrix){
        if(matrix.length==0||matrix[0].length==0)return new int[0];
        int m=matrix.length,n=matrix[0].length,row=0,col=0;
        int []order=new int[m*n];
        int [][]dirs={{-1,1},{1,-1}};
        int k=0;
        for(int i=0;i<order.length;i++){
           order[i]=matrix[row][col];
           row+=dirs[k][0];
           col+=dirs[k][1];
           if(col>n-1){
               col=n-1;
               row+=2;
               k=1-k;
           }
           if(row<0){
               row=0;
               k=1-k;
           }
           if(row>m-1){
               row=m-1;
               col+=2;
               k=1-k;
           }
           if(col<0){
               col=0;
               k=1-k;
           }
        }
        return order;
    }

    public static void main(String[]args){
        DiagonalTraverse test=new DiagonalTraverse();
        int [][]matrix={{1,2,3},{4,5,6},{7,8,9}};
        int []order=test.findDiagonalOrder(matrix);
        for(int n:order){
            System.out.print(n);
        }
    }
}
