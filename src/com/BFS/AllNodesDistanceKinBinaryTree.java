package com.BFS;

import java.util.*;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 *
 *
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 *
 *
 * Note:
 *
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 */
public class AllNodesDistanceKinBinaryTree {
    Map<TreeNode ,List<TreeNode>> map=new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res=new ArrayList<>();
            buildMap(root,null);
        if (root == null || K < 0) return res;
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        visited.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            if(K==0){
                for(int i=0;i<size;i++){
                    res.add(q.poll().val);
                }
                return res;
            }

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                for(TreeNode next:map.get(node)){
                    if(visited.contains(next))continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }
        return res;
    }
    private void buildMap(TreeNode node,TreeNode parent){
        if(node==null)return ;
        if(!map.containsKey(node)){
            map.put(node,new ArrayList<TreeNode>());
            if(parent!=null){
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }
    }
