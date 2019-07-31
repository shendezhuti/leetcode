package com.ArrayandString;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)return 0;

        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                List<Integer> prerow=triangle.get(i+1);
                int sum=Math.min(prerow.get(j),prerow.get(j+1))+triangle.get(i).get(j);
                triangle.get(j).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }

    public static  void main(String []args){
         Triangle test=new Triangle();

        List<List<Integer>> triangle=new LinkedList<>();
        List<Integer> nums1=new LinkedList<Integer>();
        nums1.add(2);
        List<Integer> nums2=new LinkedList<Integer>();
        nums2.add(3);nums2.add(4);
        List<Integer> nums3=new LinkedList<Integer>();
        nums3.add(6);        nums3.add(5);        nums3.add(7);
        List<Integer> nums4=new LinkedList<Integer>();
        nums4.add(4);        nums4.add(1);        nums4.add(8);        nums4.add(3);

        triangle.add(nums1);
        triangle.add(nums2);
        triangle.add(nums3);
        triangle.add(nums4);
         System.out.println(test.minimumTotal(triangle));
    }

}
