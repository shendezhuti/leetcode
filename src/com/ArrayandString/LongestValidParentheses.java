package com.ArrayandString;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s.length()<2||s==null)return 0;
        int n =s.length();
        int max=0;
        int leftmost=-1;
        Stack<Integer> stack= new Stack<Integer>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    leftmost=i;
                }else{
                    int j=stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,i-leftmost);
                    else max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}
