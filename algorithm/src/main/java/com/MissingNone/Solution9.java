package com.MissingNone;
//9. 回文数
public class Solution9 {
//    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//    输入: 121
//    输出: true

//    输入: -121
//    输出: false
//    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

//    输入: 10
//    输出: false
//    解释: 从右向左读, 为 01 。因此它不是一个回文数。
    public static boolean isPalindrome(int x) {
        int temp = 0;
        int number = x;
        while(x != 0) {
            if(x < 0) {
                return false;
            }
            int rev = x%10;
            x = x/10;
            if (temp>Integer.MAX_VALUE/10 || (temp==Integer.MAX_VALUE/10 && rev>7)) {
                return false;
            }
            temp = temp*10+rev;
        }
        if(number == temp) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome(-121);
        System.out.println(result);
    }
}
