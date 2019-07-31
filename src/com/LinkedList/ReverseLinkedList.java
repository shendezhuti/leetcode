package com.LinkedList;

import java.util.List;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public ListNode reverseListiterative(ListNode head) {
        ListNode prevHead=null;
        while(head!=null){
            ListNode recordNext=head.next;
            head.next=prevHead;
            prevHead=head;
            head=recordNext;
        }
        return prevHead;
    }

    public ListNode reverseListrecursive(ListNode head){

        return reverseListInt(head, null);
    }

    private  ListNode reverseListInt(ListNode head,ListNode newHead){
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public ListNode reverseListListrecursiveII(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode p=reverseListListrecursiveII(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
}
