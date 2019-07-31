package com.LinkedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
            ListNode cur=head;
            while(cur!=null&&cur.next!=null){
                if(cur.val==cur.next.val){
                    cur=cur.next.next;
                }else{
                    cur=cur.next;
                }
        }
            return head;

        }
    }
