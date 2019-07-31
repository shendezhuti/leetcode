package com.DFS;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> cur=new ArrayList<>();
        dfs(root,sum,cur,res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> cur,List<List<Integer>> res){
        if(root==null)return;
        cur.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){
            res.add(new ArrayList(cur));
        }else{
            dfs(root.left,sum-root.val,cur,res);
            dfs(root.right,sum-root.val,cur,res);
        }
        cur.remove(cur.size()-1);
    }
    }
