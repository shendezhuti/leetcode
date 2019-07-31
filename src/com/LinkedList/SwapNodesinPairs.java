package com.LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
    if(head==null||head.next==null)return head;
        ListNode record = head.next;
        head.next = swapPairs(head.next.next);
        record.next = head;
        return record;
    }

    public ListNode swapPairsiterative(ListNode head){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode point=dummy;
        while(point.next!=null&&point.next.next!=null){
            ListNode swap1=point.next;
            ListNode swap2=point.next.next;
            point.next=swap2;
            swap1.next=swap2.next;
            swap2.next=swap1;
            point=swap1;
        }
        return dummy.next;
    }
    }
