package com.Tree;

import java.util.*;

/**Given a binary tree, return the postorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [3,2,1]
 Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.right;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.left;
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postorderTraversalII(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode node = root;
        TreeNode lastvisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //查看返回栈顶元素
            node = stack.peek();
            //如果右子树为空或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastvisit) {
                list.add(node.val);
                stack.pop();
                lastvisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return list;
    }
}




