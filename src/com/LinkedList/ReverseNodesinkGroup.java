package com.LinkedList;

import java.util.List;
import java.util.Stack;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null)return null;
            Stack<ListNode> stack=new Stack<>();
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode current=dummy;
            ListNode next=dummy.next;
            while(next!=null){
                for(int i=0;i<k&&next!=null;i++){
                    stack.push(next);
                    next=next.next;
                }
                if(stack.size()!=k) return dummy.next;
                while(stack.size()!=0){
                    current.next=stack.pop();
                    current=current.next;
                }
            }
            return dummy.next;
    }

    public ListNode reverseKGroupImprove(ListNode head, int k) {
            if(head==null)return null;
            ListNode dummpy=new ListNode(0);
            dummpy.next=head;
        ListNode prev=dummpy;
        while(prev!=null){
            prev=reverse(prev,k);

        }
        return dummpy.next;
    }
    private ListNode reverse(ListNode prev,int k) {
        ListNode last = prev;
        for(int i=0;i<k+1;i++){
            last=last.next;
            if(i!=k&&last==null)return null;
        }
        ListNode tail=prev.next;
        ListNode cur=prev.next.next;
        while(cur!=last){
            ListNode next=cur.next;
            cur.next=prev.next;
            prev.next=cur;
            tail.next=next;
            cur=next;
        }
        return tail;
    }

}
