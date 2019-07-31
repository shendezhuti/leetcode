package com.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
       //corner case
        if(s.length()<t.length()){
            return "";
        }
        Map<Character,Integer>wordDict = constructMap(t);
        int slow=0,minLen=Integer.MAX_VALUE,matchcount=0,index=0;
        for(int fast=0;fast<s.length();fast++){
            char ch=s.charAt(fast);
            Integer count=wordDict.get(ch);
            if(count==null){
                continue;
            }
            wordDict.put(ch,count-1);
            if(count==1){
                //1->0
                matchcount++;
            }
            while(matchcount==wordDict.size()){
                if(fast-slow+1<minLen){
                    minLen=fast-slow+1;
                    index=slow;
                }
                char leftmost=s.charAt(slow++);
                Integer leftmostCount=wordDict.get(leftmost);
                if(leftmostCount==null){
                    continue;
                }
                wordDict.put(leftmost,leftmostCount+1);
                if(leftmostCount==0){
                    //0->1
                    matchcount--;
                }
            }
        }
        return minLen==Integer.MAX_VALUE ? "" :s.substring(index,index+minLen);
    }



    private Map<Character,Integer> constructMap(String t){
        Map<Character,Integer>  map=new HashMap<>();
        for(char ch:t.toCharArray()){
            Integer count=map.get(ch);
            if(count==null){
                map.put(ch,1);
            }else{
                map.put(ch,count+1);
            }
            }
        return map;
        }

}

