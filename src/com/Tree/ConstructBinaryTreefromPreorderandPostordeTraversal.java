package com.Tree;

/**
 *Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 *
 *
 * Example 1:
 *
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 *
 * Note:
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class ConstructBinaryTreefromPreorderandPostordeTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,0,pre.length-1,post,0,post.length-1);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd){
        if(preStart>preEnd)return null;
       if(preStart==preEnd) return new TreeNode(pre[preStart]);
        TreeNode root = new TreeNode(pre[preStart]);
        int leftSubRootInPre=preStart+1;
       int leftSubRootInPost=findLeftSubRootInPost(pre[leftSubRootInPre],post,postStart,postEnd);
       int leftSubEndInPre=leftSubRootInPre+(leftSubRootInPost-postStart);
       root.left=helper(pre, leftSubRootInPre, leftSubEndInPre,
               post, postStart, leftSubRootInPost);
       root.right=helper(pre, leftSubEndInPre + 1, preEnd,
               post, leftSubRootInPost + 1, postEnd - 1);
       return root;
    }

    private int findLeftSubRootInPost(int leftSubRootVal, int[] post, int postStart, int postEnd) {
        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == leftSubRootVal) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

    }
