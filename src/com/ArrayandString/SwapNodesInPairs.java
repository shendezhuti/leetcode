package com.ArrayandString;

import java.util.List;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {
    public class ListNode{
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode l1=dummy;
        ListNode l2=head;
        while(l2!=null && l2.next!=null){
            ListNode nextStart=l2.next.next;
            l1.next=l2.next;
            l2.next.next=l2;
            l2.next=nextStart;
            l1=l2;
            l2=l2.next;
        }
        return  dummy.next;
    }
}
