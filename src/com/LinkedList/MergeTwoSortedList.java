package com.LinkedList;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoListsiterative(ListNode l1, ListNode l2) {
    ListNode head=new ListNode(0);
    ListNode hanlder=head;
    while(l1!=null&&l2!=null){
        if(l1.val<l2.val){
            hanlder.next=l1;
            l1=l1.next;
        }else{
            hanlder.next=l2;
            l2=l2.next;
        }
        hanlder=hanlder.next;
    }
    if(l1!=null){
        hanlder.next=l1;
    }else if(l2!=null){
        hanlder.next=l2;
    }
    return  head.next;
    }

    public ListNode mergeTwoListsrecursive(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoListsrecursive(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoListsrecursive(l1,l2.next);
            return l2;
        }
    }
    }
