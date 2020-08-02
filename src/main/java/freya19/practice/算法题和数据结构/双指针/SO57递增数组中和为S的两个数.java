package freya19.practice.算法题和数据结构.双指针;

import java.util.ArrayList;
import java.util.Arrays;

public class SO57递增数组中和为S的两个数 {
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        int sum = 0, multi = left * right;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }
        }
        return res;
    }
}
