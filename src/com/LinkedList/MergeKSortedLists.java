package com.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(0);
        if(lists==null||lists.length==0)return dummy.next;
        int size=lists.length;
        ListNode current=dummy;
        PriorityQueue<ListNode>pq=new PriorityQueue<>(size, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
              return  o1.val-o2.val;
            }
        });

       for(int i=0;i<size;i++){
           if(lists[i]!=null){
               pq.add(lists[i]);
           }
       }
       while(!pq.isEmpty()){
           ListNode node=pq.poll();
           current.next=node;
           current=current.next;
           if(node.next!=null) pq.add(node.next);
       }
       return dummy.next;
    }

}
