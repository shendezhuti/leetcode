package com.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversaliterative(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.add(node);
                node=node.left;
            }
            node=stack.pop();
            list.add(node.val);
            node=node.right;
        }
        return list;
    }
    }
