package com.ArrayandString;

public class ImplementstrStrusingKMP {

  public int[] getNext(char[] pattern){
      int plen=pattern.length;
      int []next=new int[plen];
      next[0]=-1;
      int k=-1;
      int j=0;
      while(j<plen-1){
          if(k==-1||pattern[j]==pattern[k]){
              k++;
              j++;
              if(pattern[j]!=pattern[k]) {
                  next[j] = k;
              }else {
                  next[j]=next[k];
              }
          }else{
              k=next[k];
          }
      }
      return next;
  }

    public int kmp_search(char[] string,char []pattern){
      int i=0,j=0;
      int slen=string.length;
      int plen=pattern.length;
      int []next=getNext(pattern);
      while(i<slen&&j<pattern.length){
          if( j ==-1 ){
              ++i;
              ++j;
          }else if( pattern[j]==string[i]){
              ++i;
              ++j;
          }
          else{
              j=next[j];
          }
      }
      if(j==plen) return i-j;
      else return -1;
    }
    public static void main (String[] args){
        ImplementstrStrusingKMP imp=new ImplementstrStrusingKMP();

        String needle="ABABCABAA";
        String haystack="FFFABABCABAASSFDFASDF";

        int index=imp.kmp_search(haystack.toCharArray(),needle.toCharArray());
        System.out.println(index);

    }
}
