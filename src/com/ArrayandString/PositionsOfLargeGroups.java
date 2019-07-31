package com.ArrayandString;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 */
public class PositionsOfLargeGroups {

    public List<List<Integer>> largegrouppositions(String S){


        int i = 0, j = 0, N = S.length();
        List<List<Integer>> res = new ArrayList<>();
        while (j < N) {
            while (j < N && S.charAt(j) == S.charAt(i)) ++j;
            if (j - i >= 3) res.add(Arrays.asList(i, j - 1));
            i = j;
        }
        return res;
    }

    public static void main(String []args){
        PositionsOfLargeGroups test=new PositionsOfLargeGroups();
        String s="aaa";

        List<List<Integer>>res=new ArrayList<>();
        res=test.largegrouppositions(s);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i));
        }
    }
}
