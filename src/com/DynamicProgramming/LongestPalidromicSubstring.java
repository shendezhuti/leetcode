package com.DynamicProgramming;

/**
 *Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalidromicSubstring {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        String res="";
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                dp[i][j]=s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1]);
                if(dp[i][j]&&j-i+1>res.length()){
                    res=s.substring(i,j+1);
                }
            }
        }

        return res;
    }
    public static void main(String []args){
        LongestPalidromicSubstring test=new LongestPalidromicSubstring();
        String s="babaddtattarrattatddetartrateedredividerb";
        System.out.print(test.longestPalindrome(s));
    }
}
