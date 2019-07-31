package com.BinarySearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
            int lo=0,hi=A.length-1;
            while(lo<=hi){
                int mid=(lo+hi)>>>1;
                if(target==A[mid]) return mid;
                //左半段有序
                if(A[lo]<=A[mid]){
                    //target在这段
                    if(target>=A[lo]&&target<A[mid]){
                        hi=mid-1;
                    }else{
                        lo=mid+1;
                    }

                }else{
                    //右半段有序
                    if(target>A[mid]&&target<=A[hi]){
                        lo=mid+1;
                    }else{
                        hi=mid-1;
                    }
                }
            }
            return -1;
    }
    }
