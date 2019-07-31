package com.ArrayandString;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 * Accepted
 * 259,574
 * Submissions
 * 805,574
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        int len = 0, tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail)==' ') tail--;
        while (tail >= 0 && s.charAt(tail)!=' ') {
            len++;
            tail--;
        }
        return len;

    }
    }
