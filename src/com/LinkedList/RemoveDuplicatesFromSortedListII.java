package com.LinkedList;

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
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
           if(head==null)return null;
           ListNode dummy=new ListNode(head.val==0?1:0);
           ListNode cur=head;
           ListNode pre=dummy;
           ListNode first=dummy;
           while(cur!=null&&cur.next!=null){
            if(cur.val!=pre.val&&cur.val!=cur.next.val){
                first.next=cur;
                first=first.next;
            }
            pre=cur;
            cur=cur.next;
           }

           if(cur.val!=pre.val){
               first.next=cur;
               first=first.next;
           }

           first.next=null; //面对 1 1这种case
           return dummy.next;
        }
    }
