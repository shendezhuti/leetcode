package com.ArrayandString;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public String add(String a,String b){
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while(i>=0&&j>=0){
            int sum=carry;
            if(j>=0) sum+=b.charAt(j--)-'0';
            if(i>=0) sum+=a.charAt(i--)-'0';
            sb.append(sum%2);
            carry=sum/2;
        }
        if(carry==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String []args){
        AddBinary test=new AddBinary();
        String a="1011";
        String b="1011";
        System.out.print(test.add(a,b));
    }
}
