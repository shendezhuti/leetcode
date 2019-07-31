package com.ArrayandString;

import java.util.*;

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
public class WorkBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, Boolean> mem = new HashMap<String, Boolean>();
        return wordBreak(s, mem, dict);
    }

    private boolean wordBreak(String s,
                              Map<String, Boolean> mem,
                              Set<String> dict) {
        if (mem.containsKey(s)) return mem.get(s);
        if (dict.contains(s)) {
            mem.put(s, true);
            return true;
        }

        for (int i = 1; i < s.length(); ++i) {//如果右边在字典里，并且左边有解，那么返回true
            if (dict.contains(s.substring(i)) && wordBreak(s.substring(0, i), mem, dict)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }
}
