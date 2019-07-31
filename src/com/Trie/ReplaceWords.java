package com.Trie;

import com.Tree.TreeNode;

import java.util.List;

/**
 *
 */
public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        String[]tokens=sentence.split(" ");
        TrieNode trie=buildTrie(dict);
        return replaceWords(tokens,trie);

    }

    private String replaceWords(String[] tokens,TrieNode root){
        StringBuilder sb=new StringBuilder();
        for (String token : tokens) {
            sb.append(getShortestReplacement(token, root));
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }

    private String getShortestReplacement(String token, final TrieNode root) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for (char c : token.toCharArray()) {
            sb.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return sb.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict){
        TrieNode root=new TrieNode(' ');
        for(String word:dict){
            TrieNode temp=root;
            for(char c:word.toCharArray()){
                if(temp.children[c-'a']==null){
                    temp.children[c-'a']=new TrieNode(c);
                }
                temp=temp.children[c-'a'];
            }
            temp.isWord=true;
        }
        return root;
    }
        public class TrieNode{
        char val;
        TrieNode[]children;
        boolean isWord;

        public TrieNode(char val){
            this.val=val;
            this.children=new TrieNode[26];
            this.isWord=false;
        }
    }


    public static void main(String []args){
      String  sentence = "the cattle was rattled by the battery";
        String []res=sentence.split(" ");
      for(String s:res){
          System.out.println(s);
      }
    }
}
