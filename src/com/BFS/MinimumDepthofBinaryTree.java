package com.BFS;

import com.BFS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    public int minDepthBFS(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size(); // determine the loop size
            for (int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return depth;
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            depth ++;
        }
        return depth;
    }
    }
