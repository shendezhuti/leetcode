package com.DFS;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * Accepted
 * 306,098
 * Submissions
 * 753,414
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root)!=-1;
    }

    private int dfsHeight(TreeNode root){
        if(root==null)return 0;
        int leftheight=dfsHeight(root.left);
        if  (leftheight==-1 )return -1;
        int rightheight=dfsHeight(root.right);
        if  (rightheight==-1 )return -1;

        if(Math.abs(leftheight-rightheight)>1)return -1;
        return Math.max(leftheight,rightheight)+1;
    }
}
