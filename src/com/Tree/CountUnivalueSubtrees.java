package com.Tree;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 * Given binary tree,
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 *
 * return 4.
 */
public class CountUnivalueSubtrees {


    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        int []cnt=new int[1];
         dfs(root,cnt);
         return cnt[0];
    }
    public boolean dfs(TreeNode root,int []cnt){
      if(root==null)return true;
      //step1 get information from two subtree
      boolean left=dfs(root.left,cnt);
      boolean right=dfs(root.right,cnt);

      if (left&&right&&(root.left==null||root.val==root.left.val)&&(root.right==null||root.val==root.right.val)){
          cnt[0]++;
          return true;
      }
      return false;
    }
}
