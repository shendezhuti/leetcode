package com.Heap;

import java.util.PriorityQueue;

/**
 *Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder {
    PriorityQueue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<> ((a, b) -> b - a);//最大堆
        right = new PriorityQueue<> ();
    }

    public void addNum(int num) {
        if (left.isEmpty () || num <= left.peek ()) left.offer (num);
        else right.offer (num);
        if (left.size () - right.size () > 1) right.offer (left.poll ());
        if (right.size () - left.size () > 1) left.offer (right.poll ());
    }

    public double findMedian() {
        int left_len = left.size (), right_len = right.size ();
        if (((left_len + right_len) & 1) == 1) return (double) (left_len > right_len ? left.peek () : right.peek ());
        //用了bit manipulation的思想，由于这两个数字相差为1，因此可以这么判断
        else return (left.peek () + right.peek ()) / 2.0;
    }
}

