package com.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums);
         return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> templist,int []nums){
        if(templist.size()==nums.length){
            res.add(new ArrayList<>(templist));
        }else {
            for(int i=0;i<nums.length;i++){
                if(templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                backtrack(res,templist,nums);
                templist.remove(templist.size()-1);
            }
        }
    }
    public static void main(String[]args){
        int []nums={1,2,3};
        Permutation test=new Permutation();
        List<List<Integer>> res=test.permute(nums);
        int k=3;
        for(int i=0;i<res.size();i++) {
            if(i+1==k) {
                System.out.println(res.get(i).toString());
            }
        }
    }
}

