package com.ArrayandString;

public class ReverseWordsInaStringIII {

    public String reverseWords(String s) {
        char[] c=s.toCharArray();
        int n=s.length();
        for(int i=0,j=1;j<=n;j++){
            if(j==n||c[j]==' '){
                reverse(c,i,j-1);
                i=j+1;
            }
        }
        return new String(c);
    }

    public void reverse(char[]c,int start,int end){
        while(start<end){
            char temp=c[start];
            c[start]=c[end];
            c[end]=temp;
            start++;
            end--;
        }
    }
}
