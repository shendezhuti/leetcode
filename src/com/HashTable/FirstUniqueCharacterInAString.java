package com.HashTable;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int []fp=new int[26];
        for(int i=0;i<s.length();i++){
            fp[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(fp[s.charAt(i)-'a']==0){
                return i;
            }
        }
        return -1;
    }
    }
