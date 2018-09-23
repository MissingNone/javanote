package com.MissingNone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<3) {
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            int l=i+1,r=nums.length-1;
            if(nums[i]<=0) {
                List<Integer> item = new ArrayList<Integer>();
                while(l<r) {
                    if(nums[i]+nums[l]+nums[r]==0) {
                        item.add(nums[i]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        res.add(item);
                        while(r>l&&nums[l+1] == nums[l])
                            l++;
                        while(r>l&&nums[r-1] == nums[r])
                            r--;
                    }
                    if(nums[i]+nums[l]+nums[r]<0) {
                        l++;
                    }else{
                        r--;
                    }
                }
                while(i<nums.length-2 && nums[i]==nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{0,0,0,0});
    }
}
