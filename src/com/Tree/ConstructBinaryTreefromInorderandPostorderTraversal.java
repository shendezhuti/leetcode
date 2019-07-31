package com.Tree;

/**
 *Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0||postorder==null||postorder.length==0)
            return null;

        return helper(postorder,inorder,postorder.length-1,0,inorder.length-1);

    }

    private TreeNode helper(int[]postorder,int []inorder,int postEnd,int inStart,int inEnd){
        if(postEnd<0||inStart>inEnd)return null;

        TreeNode root=new TreeNode(postorder[postEnd]);
        int inIndex=0;
        for(int i=inStart;i<inEnd;i++){
            if(inorder[i]==root.val){
                inIndex=i;
                break;
            }
        }
        root.right=helper(postorder,inorder,postEnd-1,inIndex+1,inEnd);
        root.left=helper(postorder,inorder,postEnd-(inEnd-inIndex+1),inStart,inIndex-1);
        return root;
    }
}
