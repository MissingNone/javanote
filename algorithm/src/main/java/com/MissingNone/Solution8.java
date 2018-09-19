package com.MissingNone;
//8. 字符串转整数 (atoi)
public class Solution8 {
    public static int myAtoi(String str) {
        boolean flag = false;
        boolean symbol = false;
        long ret = 0;
        for(int i=0;i<str.length();i++) {
            if(((str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<=9) || (str.charAt(i)=='-' || str.charAt(i)=='+')) && str.charAt(i)!=' ') {
                if(flag) {
                    if(str.charAt(i)<'0'|| str.charAt(i)>'9'){
                        break;
                    }
                    ret = ret*10 + (str.charAt(i)-'0');

                    if(ret > Integer.MAX_VALUE){
                        ret = 2147483648l;
                        break;
                    }
                }else{
                    flag = true;
                    if(str.charAt(i)=='-') {
                        symbol=true;
                    }
                    if(str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<=9) {
                        ret=str.charAt(i)-'0';
                    }
                }
            }
            if((str.charAt(i)-'0'<0 || str.charAt(i)-'0'>9) && (str.charAt(i)!='-' && str.charAt(i)!='+') && !flag && str.charAt(i)!=' ') {
                return (int)ret;
            }

            if(flag) {
                if((str.charAt(i)<'0'|| str.charAt(i)>'9') && (str.charAt(i)!='-' && str.charAt(i)!='+')){
                    break;
                }
            }
        }

        if(symbol) {
            ret = 0 - ret;
        }
        if(ret > Integer.MAX_VALUE){
            ret = 2147483647l;
        }
        return (int)ret;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
