package com.ArrayandString;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.*;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Accepted
 * 73,948
 * Submissions
 * 195,421
 */
public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int[]sorted= Arrays.copyOf(nums,nums.length);
        Arrays.sort(sorted);
        Map<Integer,Integer> ranks=new HashMap<>();
        int rank=0;
        for(int i=0;i<sorted.length;i++){
            if(i==0||sorted[i]!=sorted[i-1]){
                ranks.put(sorted[i],++rank);
            }
        }
        FenwickTree tree=new FenwickTree(ranks.size());
        List<Integer> ans=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int sum = tree.query(ranks.get(nums[i]) - 1);
            ans.add(sum);
            tree.update(ranks.get(nums[i]), 1);
        }
        Collections.reverse(ans);
        return  ans;
    }

    private static int lowbit(int x) {
        return x & (-x);
    }

    class FenwickTree {
        private int[] sums;

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                i -= lowbit(i);
            }
            return sum;
        }
    };

}
