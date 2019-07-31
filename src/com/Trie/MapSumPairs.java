package com.Trie;

import com.Tree.TreeNode;

/**
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class MapSumPairs {
    TrieNode root;
    public MapSumPairs(){
        root=new TrieNode();
    }


    public void insert(String key,int val){
        TrieNode cur=root;
        for(char c:key.toCharArray()){
            TrieNode next=cur.mapchildren.get(c);
            if(next==null){
                next=new TrieNode();
                cur.mapchildren.put(c,next);
            }
            cur=next;
        }
        cur.isWord=true;
        cur.value=val;
    }

    public int sum(String prefix){
        TrieNode cur=root;
        for(char c:prefix.toCharArray()){
            TrieNode next=cur.mapchildren.get(c);
            if(next==null){
                return 0;
            }
            cur=next;
        }
        return dfs(cur);
    }
    private int dfs(TrieNode root){
        int sum=0;
        for(char c:root.mapchildren.keySet()){
            sum+=dfs(root.mapchildren.get(c));
        }
        return sum+root.value;
    }
}
