package com.LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head, slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        if(fast!=null){//if node number is odd ,let right half smaller
            slow=slow.next;
        }
        slow=reverse(slow);
        fast=head;
        while(slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode preHead=null;
        while(head!=null){
            ListNode recordNext=head.next;
            head.next=preHead;
            preHead=head;
            head=recordNext;
        }
        return preHead;
    }
    }
