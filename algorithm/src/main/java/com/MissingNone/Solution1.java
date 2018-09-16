package com.MissingNone;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
//    给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
//
//    你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]
    //暴力法遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
    //时间复杂度O(n^2),空间复杂度O(1)
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            int number1 = nums[i];
            int number2 = target - number1;
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j] == number2) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    //两遍哈希表。
    //时间复杂度O(n),空间复杂度O(n)
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++) {
            int number = target - nums[i];
            if(map.containsKey(number) && map.get(number) != i) {
                result[0] = i;
                result[1] = map.get(number);
                return result;
            }
        }
        return result;
    }
    //一遍哈希表。
    //时间复杂度O(n),空间复杂度O(n)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums,target);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }

    }
}
