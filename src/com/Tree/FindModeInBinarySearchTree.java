package com.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeInBinarySearchTree {
    int max = 0;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        if (root == null) return new int[0];
        inorder(root, map, max);
        List<Integer> list = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }

    private void inorder(TreeNode node, Map<Integer, Integer> map, int max) {
        if (node.left != null) inorder(node.left, map, max);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, map.get(node.val));
        if (node.right != null) inorder(node.right, map, max);
    }


    public int[] findModeImprove(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount=0;
        currCount=0;
        inorder(root);
        return modes;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handValue(root.val);
        inorder(root.right);
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    private void handValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if(currCount>maxCount){
            maxCount=currCount;
            modeCount=1;
        }else if(currCount==maxCount){
            if(modes!=null){
                modes[modeCount]=currVal;
                modeCount++;
            }
        }
    }
}