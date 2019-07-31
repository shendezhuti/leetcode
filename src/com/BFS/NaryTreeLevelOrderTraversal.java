package com.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * We should return its level order traversal:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node current = queue.poll();
                curLevel.add(current.val);
                for (Node c : current.children) {
                    queue.offer(c);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
