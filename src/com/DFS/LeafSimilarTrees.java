package com.DFS;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 *            3
 *          5   1
 *       6   2   9   8
 *          7 4
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        dfs(root1,sb1);
        dfs(root2,sb2);
        return sb1.toString().equals(sb2.toString());

    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root==null)return ;
        if(root.left==null&&root.right==null)sb.append(root.val+"-");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }
    }
