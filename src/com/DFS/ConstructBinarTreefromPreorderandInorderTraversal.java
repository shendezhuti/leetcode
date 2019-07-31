package com.DFS;

import com.DFS.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinarTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0||inorder.length==0||inorder==null)return null;
      return  helper(0,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode helper(int preStart,int inStart,int inEnd,int[]preorder,int []inorder){
        if(inStart>inEnd||preStart>preorder.length-1)return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }
        root.left=  helper(preStart+1,inStart,index-1,preorder,inorder);
        root.right=helper(preStart+(index-inStart)+1,index+1,inEnd,preorder,inorder);
        return root;
    }
}
