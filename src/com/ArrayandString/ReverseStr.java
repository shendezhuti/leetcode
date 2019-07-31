package com.ArrayandString;

/**
 * Write a function that takes a string as input
 * and returns the string reversed.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseStr {
    public String result(String s){
        int i=0;
        int j=s.length()-1;
        char[]c=s.toCharArray();
        while(i<j){
            char temp=c[j];
            c[j]=c[i];
            c[i]=temp;
            i++;
            j--;
        }
        return new String (c);
    }

    public String reverserecursive(String s){
        char []c=s.toCharArray();
        helper(0,c.length-1,c);
        return c.toString();
    }
    private void helper(int start,int end,char[]c){
        if(start>=end){
            return ;
        }
        char temp=c[start];
        c[start]=c[end];
        c[end]=temp;
        helper(start+1,end-1,c);
    }



    public static void main(String [] args){
        ReverseStr test=new ReverseStr();
        String s=new String("A man, a plan, a canal: Panama");
        System.out.print(test.result(s));
    }

}
