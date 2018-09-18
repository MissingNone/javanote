package com.MissingNone;
//7. 反转整数
public class Solution7 {
//    给定一个 32 位有符号整数，将整数中的数字进行反转。
//    输入: 123
//    输出: 321

//    输入: -123
//    输出: -321

//    输入: 120
//    输出: 21
    public static int reverse(int x) {
        int temp = 0;
        while(x != 0) {
            int rev = x%10;
            x = x/10;
            if (temp>Integer.MAX_VALUE/10 || (temp==Integer.MAX_VALUE/10 && rev>7)) {
                return 0;
            }
            if(temp<Integer.MIN_VALUE/10 || (temp==Integer.MIN_VALUE/10 && rev<-8)) {
                return 0;
            }
            temp = temp*10+rev;
        }
        return temp;
    }

    public static void main(String[] args) {
        int temp = reverse(120);
        System.out.println(temp);
    }
}
