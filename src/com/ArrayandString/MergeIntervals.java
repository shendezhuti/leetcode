package com.ArrayandString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public List<Interval> merge (List<Interval> intervals){
        List<Interval> res = new ArrayList<Interval>();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        //corner case:
        if(intervals.size()==0)
            return res;
        for(int i=0; i<intervals.size();i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i=0; i<intervals.size(); i++){
            int st = start[i];
            while(i<intervals.size()-1 && end[i] >= start[i+1]){
                i++;
            }
            int en = end[i];
            Interval intv = new Interval(st, en);
            res.add(intv);
        }
        return res;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
