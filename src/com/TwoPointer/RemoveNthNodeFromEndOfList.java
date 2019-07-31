package com.TwoPointer;

import com.LinkedList.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy=new ListNode(0);
       dummy.next=head;
          ListNode     slow=dummy, fast=dummy;

       for(int i=1;i<=n+1;i++){
           fast=fast.next;
       }

       while(fast.next!=null){
           fast=fast.next;
           slow=slow.next;
        }
       slow.next=slow.next.next;
       return dummy.next;
    }
    }
