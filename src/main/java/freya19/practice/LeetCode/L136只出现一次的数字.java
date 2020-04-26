package freya19.practice.LeetCode;
/*
给定一个非空整数数组，除了某个元素只出现一次以外，
其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度O(n)。
你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,1]     输出: 1

示例 2:
输入: [4,1,2,1,2]     输出: 4
 */

import java.util.*;

public class L136只出现一次的数字 {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> resMap = new HashMap<>(); // 存放数字出现次数及对应的数字
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int key = nums[i];  //元素
            if (!resMap.containsKey(key)) {
                resMap.put(key, 1);
            } else {
                int value = resMap.get(key);  //次数
                resMap.put(key, value + 1);
            }
        }

        Set<Integer> keys = resMap.keySet();
        Integer res = 0;
        for (Integer key : keys) { //key就是元素，下面通过key（元素）来找到对应的value（次数）
            if (resMap.get(key).equals(1)) { //如果次数为1
                res = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 2, 1, 5, 6, 3, 7, 6, 7}; //4
        L136只出现一次的数字 l136 = new L136只出现一次的数字();
        System.out.println(l136.singleNumber(nums));
    }
}
