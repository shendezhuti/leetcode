package com.Tree;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 *
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    int max=0;
    public  int longestConsecutive(TreeNode root){
        if(root==null)return 0;
        int res=0;
        dfs(root,0,root.val);
        return max;
    }

    private void dfs(TreeNode root, int curmax,int target){
        if(root==null)return ;
        if(root.val==target)curmax++;
        else curmax=1;
        max=Math.max(max,curmax);
        dfs(root.left,curmax,target+1);
        dfs(root.right,curmax,target+1);
    }
}
