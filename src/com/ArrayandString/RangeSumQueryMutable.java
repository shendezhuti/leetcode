package com.ArrayandString;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {
    FenwickTree tree_;
    int []nums_;
    public RangeSumQueryMutable(int[] nums) {
        nums_=nums;
        tree_=new FenwickTree(nums.length);
        for(int i=0;i<nums.length;i++) {
            tree_.update(i+1,nums[i]);
        }
    }

    public void update(int i, int val) {
        tree_.update(i+1,val-nums_[i]);
        nums_[i]=val;
    }

    public int sumRange(int i, int j) {
        return tree_.query(j+1)-tree_.query(i);
    }

    class FenwickTree {
        int sums_[];
        public FenwickTree(int n) {
            sums_ = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < sums_.length) {
                sums_[i] += delta;
                i += i & -i;
            }
        }

        public int query(int i) {//表示寻找的是1到第i个数的和
            int sum = 0;
            while (i > 0) {
                sum += sums_[i];
                i -= i & -i;
            }
            return sum;
        }
    }

}
