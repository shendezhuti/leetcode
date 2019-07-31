package com.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class CousinsinBinaryTree {


    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size=q.size();
            boolean isxExist=false;
            boolean isyExist=false;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.val==x) isxExist=true;
                if(node.val==y)isyExist=true;
                if(node.left!=null&&node.right!=null){
                    if(node.left.val==x&&node.right.val==y)return false;
                    if(node.right.val==x&&node.left.val==y)return false;
                }
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            if(isxExist&&isyExist)return true;
            else if(isxExist||isyExist)return false;
        }
        return false;

    }
    }
