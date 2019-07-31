package com.HashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 *Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

    //花花酱的第二种offline解法
    public int longestConsecutive(int[] nums) {
        HashSet set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int l = 0;
                while(set.contains(i++)){
                    l++;
                }
                max = Math.max(l, max);
            }
        }
        return max;
    }

    public int longestConsecutiveHM(int[] nums) {
        int res=0;
        HashMap<Integer,Integer>map =new HashMap<Integer, Integer>();
        for(int n:nums){
            if(!map.containsKey(n)){
                int left=(map.containsKey(n-1))? map.get(n-1):0;
                int right=(map.containsKey(n-1))? map.get(n-1):0;
                int sum=left+right+1;
                map.put(n,sum);
                res=Math.max(res,sum);
                map.put(n-left,sum);
                map.put(n+right,sum);
            }else{
                continue;
            }
        }
        return res;
    }
}
