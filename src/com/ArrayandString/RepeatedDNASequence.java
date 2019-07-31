package com.ArrayandString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words=new HashSet<>();
        Set<Integer> doubleWords=new HashSet<>();
        List<String> rv=new ArrayList<>();
        char[]map=new char[26];
        map['C'-'A']=1;
        map['G'-'A']=2;
        map['T'-'A']=3;
        for(int i=0;i<s.length()-9;i++){
            int v=0;
            for(int j=i;j<i+10;j++){
                v<<=2;
                v|=map[s.charAt(j)-'A'];
            }
            if(!words.add(v)&&doubleWords.add(v)){//注意这个的有个大小条件，先判断前面的，之后才判断后面的
                rv.add(s.substring(i,i+10));
            }
        }
        return rv;
    }
}
