package com.MissingNone;

import java.util.Arrays;

public class Solution455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while(child<g.length && cookie<s.length) {
            if(s[cookie]>=g[child]) {
                child++;
            }
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2,3},new int[]{1,1}));
    }
}
