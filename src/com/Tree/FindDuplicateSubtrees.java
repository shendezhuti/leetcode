package com.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *
 *       2
 *      /
 *     4
 * and
 *
 *     4
 * Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res= new LinkedList<TreeNode>();
        StringBuilder sb=new StringBuilder();
        dfs(root,sb,res,new HashMap<>());
        return res;
    }
    private String dfs(TreeNode cur, StringBuilder sb, List<TreeNode> res, Map<String,Integer> map){
        if(cur==null)return "#";
        String serial =sb.append(cur.val).append(",").append(dfs(cur.left,sb, res, map)).append(",").append(dfs(cur.right,sb, res, map)).toString() ;
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;

    }


    public List<TreeNode> findDuplicateSubtreesII(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        dfs(root, new HashMap<>(), res);
        return res;
    }

    public String dfs(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + dfs(cur.left, map, res) + "," + dfs(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }



    }
