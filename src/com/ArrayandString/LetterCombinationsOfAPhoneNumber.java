package com.ArrayandString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
       List<String >res =new ArrayList<>();
       if(digits==null||digits.length()==0){
           return res;
       }
       StringBuilder sb=new StringBuilder();
        Map<Integer,String > worddict=constructword();
        dfsHelper(digits,0, worddict,sb,res);
       return res;
    }
    private void dfsHelper(String digits,int index, Map<Integer,String > worddict, StringBuilder sb, List<String >res){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        //recursive rule
        int ch=digits.charAt(index)-'0';
        String values=worddict.get(ch);
        for(char c:values.toCharArray()){
            sb.append(c);
            dfsHelper(digits,index+1,worddict,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    private Map<Integer,String> constructword(){
        Map<Integer,String> worddict=new HashMap<>();
        worddict.put(0,"");
        worddict.put(1,"");
        worddict.put(2,"abc");
        worddict.put(3,"def");
        worddict.put(4,"ghi");
        worddict.put(5,"jkl");
        worddict.put(6,"mno");
        worddict.put(7,"pqrs");
        worddict.put(8,"tuv");
        worddict.put(9,"wxyz");
        return worddict;
    }
}
