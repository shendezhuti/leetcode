package com.BFS;

import com.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * Accepted
 * 158,924
 * Submissions
 * 336,572
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)return res;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(i==size-1) res.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
        }
        return res;

    }


        public List<Integer> rightSideView(TreeNode root) {
     List<Integer> res=new ArrayList<>();
     dfs(root,res,0);
     return res;
    }
    private void dfs(TreeNode root, List<Integer> res,int depth ){
        if(root==null)return ;
        if(depth==res.size()){
            res.add(root.val);
        }
        dfs(root.right,res,depth+1);
        dfs(root.left,res,depth+1);
    }
   }
