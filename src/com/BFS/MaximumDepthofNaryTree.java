package com.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 * We should return its max depth, which is 3.
 *
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class MaximumDepthofNaryTree {

    public int maxDepth(Node root) {
        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                Node current = queue.poll();
                for(Node child: current.children) queue.offer(child);
            }

            depth++;
        }

        return depth;

    }
    }
