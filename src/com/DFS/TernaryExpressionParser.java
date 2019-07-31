package com.DFS;

/**
 *Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression.
 * You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F.
 * #1
 * Input: "F?1:T?4:5"
 *
 * Output: "4"
 *
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 *
 *              "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 *           -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 *           -> "4"                                    -> "4"
 *
 * #2
 * Input: "T?T?F:5:3"
 *
 * Output: "F"
 *
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 *
 *              "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 *           -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 *           -> "F"                                    -> "F"
 */
public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        if(expression==null||expression.length()==0){
            return expression;
        }
        char[]exp=expression.toCharArray();
        return dfs(exp,0,exp.length-1)+"";
    }
    private char dfs(char[]c,int start,int end){
        if(start==end){
            return c[start];
        }
        int count=0,i=start;
        for(;i<=end;i++){
            if(c[i]=='？'){
                count++;
            }else if(c[i]==':'){
                count--;
                if(count==0){
                    break;
                }
            }
        }
        return c[start]=='T'?dfs(c,start+2,i-1):dfs(c,i+1,end);
    }
    }
