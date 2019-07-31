package com.Tree;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree
 * such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBSTtoGreaterTree {
    int sum=0;
    public TreeNode convertBST(TreeNode root){
        convert(root);
        return root;
    }
    public void convert(TreeNode cur){
        if(cur==null) return ;
        convert(cur.right);
        cur.val+=sum;
        sum=cur.val;
        convert(cur.left);
    }


    public TreeNode convertBSTII(TreeNode root) {
        // Write your code here
        int sum=0;
        helper(root,sum);
        return root;
    }

    public int helper(TreeNode root, int sum) {
        if(root==null)return sum;
        int right=helper(root.right,sum);
        root.val+=sum;
        int left=helper(root.left,root.val);
        return left;
    }

}
