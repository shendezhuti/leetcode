package com.Tree;

import java.util.Stack;

/**
 *Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique.
 *
 * Follow up:
 * Could you do it using only constant space complexity?
 *
 * Input[5,2,6,1,3]false
 * Input[5,2,1,3,6]true;
 */
public class VeriPreorderSequenceinBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {

        Stack<Integer> stk = new Stack<Integer>();
        // 初始化最小值为最小整数
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            // 违反最小值限定则是无效的
            if (num < min) return false;
            // 将路径中所有小于当前的数pop出来并更新最小值
            while (!stk.isEmpty() && num > stk.peek()) {
                min = stk.pop();
            }
            // 将当前值push进去
            stk.push(num);
        }
        return true;
    }

    public static void main(String[]args){
        VeriPreorderSequenceinBinarySearchTree test=new VeriPreorderSequenceinBinarySearchTree();
        int []preorder={5,2,1,3,6};
        System.out.print(test.verifyPreorder(preorder));
    }
}
