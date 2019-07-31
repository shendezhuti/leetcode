package com.DynamicProgramming;

import com.sun.tools.javac.util.List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */


public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> indict=new HashSet();
        Map<String,Boolean> mem=new HashMap<String,Boolean>();
        return helper(s,indict,mem);
    }

    private boolean helper(String s, Set<String> indict, Map<String,Boolean> mem){
        //判断是否存储了
        if(mem.get(s)==true) {
            return true;
        }
        //判断dict是否已经有了s
        if(indict.contains(s)){
            mem.put(s,true);
            return true;
        }
        //尝试每一个点
        for(int i=1;i<s.length();i++){
        String right=s.substring(i);
        String left=s.substring(0,i);
        if(indict.contains(right)&&helper(left,indict,mem)==true){
            mem.put(s,true);
            return true;
        }
        }
        mem.put(s,false);
        return false;
    }
    }
