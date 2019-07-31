package com.BitManipulation;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
                  if(nums.length == 0||nums==null)
                         return 0;

                 int[] cnt = new int[32];
                 for(int i = 0; i < nums.length; i++){
                                  for(int j = 0; j < 32; j++){
                                 if( (nums[i]>>j & 1) ==1){
                                         cnt[j]++;
                                    }
                            }
                     }
                int res = 0;
                for(int i = 0; i < 32; i++){
                         res += (cnt[i]%3 << i);
                      //res |= (cnt[i]%3 << i);
                    }
              cnt = null;
                return res;
    }


    public int singleNumberMostEfficient(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
