package com.DFS;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 * ---------------------
 */
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList.size()==0||nestedList==null)return 0;
        int []depthArray={0};
        findDepth(nestedList,depthArray,1);
        return dfs(nestedList,depthArray[0]);
    }

    private void findDepth(List<NestedInteger> nestedList,int []depthArray,int depth){
        for(NestedInteger n:nestedList){
            depthArray[0]=Math.max(depthArray[0],depth);
            if(n.isInteger()){
                continue;
            }else{
                findDepth(nestedList,depthArray,depth+1);
            }
        }
    }

    private int dfs(List<NestedInteger> nestedList,int depth){
        int res=0;
        for(NestedInteger n:nestedList){
            if(n.isInteger()){
              res+= n.getInteger()*depth;
            }else{
                res+=dfs(nestedList,depth-1);
            }
        }
        return res;
    }
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedListWeightSum.NestedInteger> getList();
    }
    }
