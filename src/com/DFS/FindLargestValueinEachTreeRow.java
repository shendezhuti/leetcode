package com.DFS;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root, res,1);
        return res;
    }
    private void dfs(TreeNode root, List<Integer>res,int depth){
        if(root==null)return ;
        if(depth==res.size()){
            res.add(root.val);
        }else{
            res.set(depth,Math.max(res.get(depth),root.val));
        }
        dfs(root.left,res,depth+1);
        dfs(root.right,res,depth+1);
    }
    }
