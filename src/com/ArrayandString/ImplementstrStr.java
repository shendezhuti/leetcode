package com.ArrayandString;

/**
 * Return the index of the first occurrence
 * of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string?
 * This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0
 * when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementstrStr {

    public int Str(String haystack,String needle){
        if(needle.length()==0) return 0;
        if(haystack.length()==0)return -1;

        for(int i=0;i<haystack.length();i++){
            if(needle.length()+i>haystack.length())return -1;
            for(int j=0;j<needle.length();j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)) break;
                if(j==needle.length()-1) return i;
            }
        }

        return -1;
    }
    public static  void  main (String []args){
        String haystack="hello";
        String needle="ll";
        ImplementstrStr imp=new ImplementstrStr();
        System.out.println(imp.Str(haystack,needle));
    }
}
