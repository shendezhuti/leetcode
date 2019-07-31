package com.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreeII {

    public List<TreeNode> generateTrees(int n) {

        return helper(1,n);

    }

    public List<TreeNode> helper(int min, int max){
        List<TreeNode> result=new ArrayList<>();
        if(min>max) return  result;
        for(int rt=min;rt<=max;rt++) {
            List<TreeNode> leftList = helper(min, rt - 1);
            List<TreeNode> rightList = helper(rt + 1, max);
            if (leftList.size() == 0 && rightList.size() == 0) {
                TreeNode root = new TreeNode(rt);
                result.add(root);
            } else if (leftList.size() == 0) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(rt);
                    root.right = right;
                    result.add(root);
                }

            } else if (rightList.size() == 0) {
                for(TreeNode left:leftList){
                    TreeNode root=new TreeNode(rt);
                    root.left=left;
                    result.add(root);
                }
            }else {
                for(TreeNode left:leftList){
                    for(TreeNode right:rightList){
                        TreeNode root=new TreeNode(rt);
                        root.left=left;
                        root.right=right;
                        result.add(root);
                    }
                }
            }
        }
        return result;
        }
    }

