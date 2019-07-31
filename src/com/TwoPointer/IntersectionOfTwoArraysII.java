package com.TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            hs.put(nums1[i],hs.getOrDefault(nums1[i],0));
        }

        for(int i=0;i<nums2.length;i++){
            if(hs.containsKey(nums2[i])&&hs.get(nums2[i])>0){
                arrayList.add(nums2[i]);
            }
        }
        int j=arrayList.size();
        int [] res= new int[j];
        for(int n:arrayList){
            res[j++]=n;
        }
        return res;
    }
    }
