package com.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new LinkedList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null)return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int num=queue.size();
            List<Integer> templist=new LinkedList<>();
            for(int i=0;i<num;i++){
                if(queue.peek().left!=null)queue.add(queue.peek().left);
                if(queue.peek().right!=null)queue.add(queue.peek().right);
                templist.add(queue.poll().val);
            }
            res.add(templist);
        }
        return res;
    }
    }
