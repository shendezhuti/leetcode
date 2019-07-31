package com.LinkedList;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 *
 * Note:
 *
 * You must return the copy of the given head as a reference to the cloned list.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode c=head;
        while(c!=null){
            RandomListNode next=c.next;
            c.next=new RandomListNode(c.label);
            c.next.next=next;
            next=c;
        }
        c=head;
        while(c!=null){
            if(c.random!=null){
                c.next.random=c.random.next;
            }
            c=c.next.next;
        }
        c=head;
        RandomListNode copyHead=head;
        RandomListNode copy=copyHead;
        while(copy.next!=null){
            c.next=c.next.next;
            c=c.next;
            copy.next=copy.next.next;
            copy=copy.next;
        }
        c.next=c.next.next;
        return copyHead;

    }


    public class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}
