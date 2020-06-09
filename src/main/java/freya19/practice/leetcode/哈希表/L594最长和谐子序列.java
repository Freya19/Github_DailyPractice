package freya19.practice.leetcode.哈希表;

import java.util.HashMap;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3]
 * <p>
 * 和谐序列中最大数和最小数之差正好为 1，应该注意的是序列的元素不一定是数组的连续元素
 */

public class L594最长和谐子序列 {
    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int longest = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                longest = Math.max(longest, map.get(num) + map.get(num + 1));
            }
        }
        return longest;
    }
}
