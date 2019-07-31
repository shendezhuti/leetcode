package com.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversalI(TreeNode root) {
        List<Integer>pre=new LinkedList<Integer>();
        if(root==null)return pre;
        pre.add(root.val);
        pre.addAll(preorderTraversalI(root.left));
        pre.addAll(preorderTraversalI(root.right));
        return pre;
    }
    /**
     *Recursive method with List as returning value:
     */

    public List<Integer> preorderTraversalII(TreeNode root) {
        List<Integer>pre=new LinkedList<Integer>();
        preHelper(root,pre);
        return pre;
    }

    public void preHelper(TreeNode root,List<Integer>pre){
        if(root==null)return ;
        pre.add(root.val);
        preHelper(root.left,pre);
        preHelper(root.right,pre);
    }
    /**
     * Recursive method with Helper method to have a List as paramater, so we can modify the parameter and don't have to instantiate a new List at each recursive call:
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        // 用来暂存节点的栈
        Stack<TreeNode> stack=new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node=root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node!=null||!stack.isEmpty()){
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while(node!=null) {
                // 为了之后能找到该节点的右子树，暂存该节点
                list.add(node.val);
                stack.push(node);
                node=node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if(!stack.isEmpty()){
                node=stack.pop();
                node=node.right;
            }
        }
        return list;
    }
    }
