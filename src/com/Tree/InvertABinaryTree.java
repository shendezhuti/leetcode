package com.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * nvert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class InvertABinaryTree {

    public TreeNode invertTreeDFS(TreeNode root) {
         if(root==null)return null;
         TreeNode tempRight = root.right;
         root.right = invertTreeDFS(root.left);
         root.left = invertTreeDFS(tempRight);
         return root;
    }
     /*
    The above solution is correct, but it is also bound to the
     application stack, which means that it's no so much scalable -
     (you can find the problem size that will overflow the stack and crash your application),
    so more robust solution would be to use stack data structure.
     */


     /*
     The idea is that we need to swap the left and right child of all nodes in the tree.
      So we create a queue to store nodes whose left and right child have not been swapped yet.
       Initially, only the root is in the queue. As long as the queue is not empty, remove the next node from the queue,
       swap its children, and add the children to the queue. Null nodes are not added to the queue.
     Eventually, the queue will be empty and all the children swapped, and we return the original root.
      */
    public TreeNode invertTreeImproveSpace(TreeNode root){
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            TreeNode temp=current.left;
            current.left=current.right;
            current.right=temp;
            if(current.left!=null)queue.add(current.left);
            if(current.right!=null)queue.add(current.right);
        }
        return  root;
    }
}
