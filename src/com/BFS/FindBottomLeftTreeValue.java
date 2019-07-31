package com.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int res=0;
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode node=q.poll();
            for(int i=0;i<size;i++){
                if(i==0) res=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
        }
        return res;
    }
    }
