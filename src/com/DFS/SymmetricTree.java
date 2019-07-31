package com.DFS;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *    Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        return root==null||isSymmetricHelp(root.left,root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val==right.val){
            return isSymmetricHelp(left.left,right.right)&&isSymmetricHelp(right.left,left.right);
        }
        return false;
    }
    }
