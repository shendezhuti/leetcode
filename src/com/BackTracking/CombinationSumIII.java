package com.BackTracking;

import com.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combination(res,new ArrayList<>(),k,1,n);
        return res;
    }
    private static void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() > k) {
            return;
        }
        if (comb.size() == k && n == 0) {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n && i<=9; i++) {

            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);

        }
    }

    public static void main(String[]args){
        CombinationSumIII test=new CombinationSumIII();
        int n=15,k=3;
        List<List<Integer>>res= test.combinationSum3(k,n);
        for( int i=0;i<res.size();i++){
            System.out.print(res.get(i));
        }
    }
}
