package com.ArrayandString;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedLIstII {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public ListNode deleteDuplicate(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0 == head.val ? 1 : 0);// to guarantee the dummy node is not same as the original head.
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode first = dummy; // the first node in the new unduplicated(result) list.
        while (cur != null && cur.next != null) {
            if (cur.val != pre.val && cur.val != cur.next.val) { // we found a unique node, we connect it at the tail of the unduplicated list, and update the first node.
                first.next = cur;
                first = first.next;
            }
            pre = cur;
            cur = cur.next;
        }
        if (pre.val != cur.val) {  // the last node needs to be dealt with independently
            first.next = cur;
            first = first.next;
        }
        first.next = null;  // the subsequent list is duplicate.
        return dummy.next;

    }
}
