package com.DFS;

import com.BackTracking.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 * Accepted
 * 116,326
 * Submissions
 * 299,590
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l=0,r=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l != 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        List<String> res= new ArrayList<>();
        StringBuilder sb=new StringBuilder(s);
        dfs(0,l,r,res,sb);
        return res;
    }

    private boolean isValid(StringBuilder sb){
        int count=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='(')++count;
            if(sb.charAt(i)==')')--count;
            if(count<0)return false;
        }
        return count==0;
    }

    private void dfs(int start,int l,int r,List<String>res,StringBuilder sb){
        if(l==0&&r==0){
            if(isValid(sb)) {
                res.add(sb.toString());
                return ;
            }
        }

        for(int i=start;i<sb.length();i++){
            if(i!=start&&sb.charAt(i)==sb.charAt(i-1))continue;;
            if(sb.charAt(i)==')'||sb.charAt(i)=='('){
                StringBuilder nsb=new StringBuilder(sb.toString());
                nsb.deleteCharAt(i);
                if(r>0&&sb.charAt(i)==')') dfs(i,l,r-1,res,nsb);
                else if(l>0&&sb.charAt(i)=='(') dfs(i,l-1,r,res,nsb);
            }
        }
    }

    public static void main(String[]args){
        String s="()())()";
        RemoveInvalidParentheses test=new RemoveInvalidParentheses();
        List<String> res =test.removeInvalidParentheses(s);

        for(int i=0;i<res.size();i++) {
            System.out.println(res.get(i));
        }


    }
}
