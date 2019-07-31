package com.Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class TwoSumIVInputisABST {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer>  set= new HashSet<>();
        return dfs(root,set,k);
    }
    private boolean dfs(TreeNode root, HashSet<Integer>set,int k){
            if(root==null)return false;
            if(set.contains(k-root.val))return true;
            set.add(root.val);
            return dfs(root.left,set,k)||dfs(root.right,set,k);
    }
    }
