package com.DFS;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 */
public class FindBottomLeftTreeValue {
    int res=0;
    int h=0;
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)return 0;
        dfs(root,1);
        return res;
    }
    private void dfs(TreeNode root,int depth){
        if(root==null)return;
        if(h<depth){
            res=root.val;
            h=depth;
        }
        dfs(root.left,depth+1);
        dfs(root.left,depth+1);
    }

    public int findBottomLeftValueNOG(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
        return res[0];
    }
    }
