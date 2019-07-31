package com.LinkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead=new ListNode(0),biggerHead=new ListNode(0);
        ListNode small=smallerHead,big=biggerHead;
        while(head!=null){
            if(head.val<x){
                small=head;
                small=small.next;
            }else{
                big=head;
                big=big.next;
            }
            head=head.next;
        }

        small.next=biggerHead.next;
        big.next=null;//// cut off anything after bigger 没有这行代码会有memory limit exceeded
        return smallerHead.next;
    }
    }
