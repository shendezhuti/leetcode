package com.ArrayandString;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {

    public String reverseVowels(String s) {
        if(s.length()==0||s==null)return "";
        String vowels="aeiouAEIOU";
        int left=0,right=s.length()-1;
        char[]array=s.toCharArray();
        while(left<right){
            while(left<right&&vowels.indexOf(array[left])==-1){
                left++;
            }
            while(left<right&&vowels.indexOf(array[right])==-1){
                right--;
            }
            char temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
        return new String(array);

    }
    }
