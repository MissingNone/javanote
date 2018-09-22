package com.MissingNone;

import java.util.HashMap;
import java.util.Map;

//14. 最长公共前缀
public class Solution14 {
//    编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。
//    输入: ["flower","flow","flight"]
//    输出: "fl"

//    输入: ["dog","racecar","car"]
//    输出: ""
//    解释: 输入不存在公共前缀。
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        int index = 0;
        boolean flag = true;
        String temp = "";
        String first = "";
        if(strs.length>0) {
            while(flag) {
                for(int i=0;i<strs.length;i++) {
                    if(strs[i].length()<=index) {
                        temp="";
                        flag = false;
                        break;
                    }
                    String c = String.valueOf(strs[i].charAt(index));
                    temp = c;
                    if(i == 0) {
                        first = c;
                    }
                    if(!c.equals(first)) {
                        temp="";
                        flag = false;
                        break;
                    }
                }
                result+=temp;
                temp="";
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = longestCommonPrefix(new String[]{"aa","a"});
        System.out.println(result);
    }
}
