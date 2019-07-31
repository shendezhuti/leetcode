package com.ArrayandString;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows){

        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows==0) return null;

        for(int j=0;j<numRows;j++){
        List<Integer>row=new ArrayList<Integer>();
        row.add(1);
        for(int i=1;i<j;i++){
            List<Integer> prerow=res.get(j-1);
            int temp=prerow.get(i-1)+prerow.get(i);
            row.add(temp);
        }
        if(j!=0)row.add(1);
        res.add(row);
        }
        return res;
    }
}
