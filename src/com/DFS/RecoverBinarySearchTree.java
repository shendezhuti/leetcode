package com.DFS;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    TreeNode firstElement=null;
    TreeNode secondElement=null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp=firstElement.val;
        firstElement.val=secondElement.val;
        secondElement.val=temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if(firstElement==null&&prevElement.val>=root.val){
            firstElement=prevElement;
        }
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if(firstElement!=null&&prevElement.val>=root.val){
            secondElement=root;
        }
        prevElement=root;
        traverse(root.right);
    }
    }
