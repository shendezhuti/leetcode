package com.DynamicProgramming;

/**
 *Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
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
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;

        for (int pi = 1; pi <= p.length(); pi++) {
            if (p.charAt(pi - 1) == '*') {
                match[0][pi] = match[0][pi - 1];
            }
        }
        for (int si = 1; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                if (s.charAt(si - 1) == p.charAt(pi - 1) || p.charAt(pi - 1) == '?') {
                    match[si][pi] = match[si - 1][pi - 1];
                } else if (p.charAt(pi - 1) == '*') {
                    match[si][pi] = match[si - 1][pi] || match[si][pi - 1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
