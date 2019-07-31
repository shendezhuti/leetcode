package com.ArrayandString;

public class ReverseWordinaString {
    public String reverseword(String s) {
        if (s == null) return null;
        char[] a = s.toCharArray();
        int n = a.length;
        reverse(a, 0, n - 1);
        reverseWords(a, n);
        return cleanSpaces(a, n);
    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
        }
    }

    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++;//skip spaces
            while (j < i || j < n && a[j] != ' ') j++;//skip non spaces
            reverse(a, i, j - 1);//reverse the word
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
        }
        return new String(a).substring(0,i);
    }

    public static void main(String []args){

    }
}
