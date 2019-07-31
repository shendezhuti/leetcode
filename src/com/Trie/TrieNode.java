package com.Trie;


import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean isWord;
    public TrieNode [] children;
    public Map<Character,TrieNode> mapchildren;
    public int value;

    public TrieNode(){
        children=new TrieNode[26];
        mapchildren=new HashMap<Character,TrieNode>();
        isWord=false;
        value=0;
    }

}
