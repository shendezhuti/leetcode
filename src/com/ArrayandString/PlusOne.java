package com.ArrayandString;

public class PlusOne {
    public int []plusone(int []digits){
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            if(carry==0)return digits;
            int temp=digits[i]+carry;
             carry=temp/10;
            digits[i]=temp%10;

        }
        if(carry!=0) {
            int[] result = new int [digits.length + 1];
            result[0] = 1;
            return result;

        }
      return digits;
    }
    public static void main(String []args){
        PlusOne test=new PlusOne();
        int []digits={4,3,2,1};
        int []res=test.plusone(digits);
        for(int n:res){
            System.out.print(n);
        }

    }
}
