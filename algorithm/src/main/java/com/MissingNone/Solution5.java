package com.MissingNone;

import java.util.logging.Logger;

//5. 最长回文子串
public class Solution5 {
//    输入: "babad"
//    输出: "bab"
//    注意: "aba"也是一个有效答案。

//    输入: "cbbd"
//    输出: "bb"
    public static String longestPalindrome(String s) {
        if("".equals(s)) {
            return "";
        }
        int len = s.length();
        if(len ==1) {
            return s;
        }
        int longest = 1;
        int start = 0;
        char[] sArr = s.toCharArray();
        boolean[][] tb = new boolean[len][len];
        for(int i=0;i<len;i++) {
            tb[i][i] = true;
            if(i<len - 1) {
                if(sArr[i]==sArr[i+1]) {
                    tb[i][i+1] = true;
                    longest=2;
                    start=i;
                }
            }
        }
        for(int l=3;l<=len;l++) {
            for(int i=0;l+i-1<len;i++) {
                int j = l+i-1;
                if(sArr[i]==sArr[j] && tb[i + 1][j - 1]) {
                    tb[i][j] = true;
                    start=i;
                    longest=l;
                }
            }
        }
        System.out.println(start+","+longest);
        return s.substring(start,start+longest);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
