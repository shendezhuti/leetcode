package com.DynamicProgramming;

/**
 *Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * output:false
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        //assumption * can not be the head of p ,otherwise, index overflow
        if(s==null|p==null)return false;
        boolean [][]match=new boolean [s.length()+1][p.length()+1];
        //no chars chosen from either of the string should match
        match[0][0]=true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                //*never be the first character
                match[0][i]=match[0][i-2];
            }
        }

        for(int si=1;si<=s.length();si++){
            for(int pi=1;pi<=p.length();pi++){
                if(p.charAt(pi-1)=='.'||p.charAt(pi-1)==s.charAt(si-1)){
                    match[si][pi]=match[si-1][pi-1];
                }else if(p.charAt(pi-1)=='*'){
                    if (p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.') {
                        match[si][pi]=match[si][pi-2]||match[si-1][pi];
                    }else{
                        match[si][pi]=match[si][pi-2];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
    }
