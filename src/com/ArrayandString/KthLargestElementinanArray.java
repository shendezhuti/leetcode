package com.ArrayandString;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
    public int findKthLargestII(int[] nums, int k) {
        k=nums.length-k;
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi){
            int j=partition(nums,lo,hi);
            if(j<k){
                lo=j+1;
            }else if(j>k){
                hi=j-1;
            }else{
                break;
            }
        }
        return nums[k];
    }

    //使用一个最小优先队列
    public  int findKthLargestIII(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int val:nums){
            pq.offer(val);
        }
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
    private void exch(int []a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private boolean less(int v,int w){
        return v<w;
    }

    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    }
