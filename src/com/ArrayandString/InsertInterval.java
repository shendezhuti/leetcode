package com.ArrayandString;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        int i = 0, size = intervals.length;
        while (i < size && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < size && intervals[i][0] <= newInterval[1]) {
            int[] cur = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            newInterval = cur;
            i++;
        }
        res.add(newInterval);
        while (i < size) {
            res.add(intervals[i]);
            i++;
        }
        int[][] insert = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            insert[j] = res.get(j);
        }
        return insert;
    }
}
