package com.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new LinkedList<List<Integer>>();
        Queue<TreeNode > queue=new LinkedList<TreeNode>();
        if(root==null)return res;
        queue.add(root);
        boolean zigzag=false;
        while(!queue.isEmpty()){
            List<Integer>templist=new LinkedList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(zigzag){
                    templist.add(0,node.val);
                }else{
                    templist.add(node.val);
                }
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(templist);
            zigzag=!zigzag;
        }
        return res;

    }
    }
