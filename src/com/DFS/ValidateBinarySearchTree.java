package com.DFS;

import java.util.Stack;

/**
 *
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(pre!=null&&root.val<=pre.val)return false;
            pre=root;
            root=root.right;
        }
        return true;
    }

    public boolean isValidBSTrec(TreeNode root) {
        if(root==null)return true;
        return helper(root,null,null);

    }

    private boolean helper(TreeNode root,Integer min,Integer max){
        if(root==null)return true;
        if(min!=null&&root.val<=min) return false;
        if(max!=null&&root.val>=max)return false;
        return helper(root.left,min,root.val)&&helper(root.right,root.val,max);
    }


    public boolean isValidBSTrec2(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return dfs(root.left, minVal, root.val) && dfs(root.right, root.val, maxVal);
    }
    }
