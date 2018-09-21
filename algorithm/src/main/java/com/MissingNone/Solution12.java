package com.MissingNone;

import java.util.HashMap;
import java.util.Map;

//12. 整数转罗马数字
public class Solution12 {
    public static String intToRoman(int num) {
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            int count=num/nums[i];
            while(count!=0){
                sb.append(romans[i]);
                count--;
            }
            num=num%nums[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(800));
    }
}
