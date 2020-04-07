package freya19.practice.LeetCode;
/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2)
 */

import java.util.Arrays;

public class L16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < len; i++) {
            int start = i + 1, end = len - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(target - sum)<Math.abs(target - res))
                    res=sum;
                if (sum < target)
                    start++;
                else if (sum > target)
                    end--;
                else
                    return res;
            }
        }
        return res;
    }
}
