package freya19.practice.面试;

import java.util.Arrays;

public class 最接近的三数之和 {

    public int threeSum(int[] nums, int target) {

        // 先对原数组进行排序
        Arrays.sort(nums);
        // 初始 结果
        int res = nums[0] + nums[1] + nums[2];
        int left, right, sum;

        // 定下来一个元素， 其余两个元素用对撞指针找
        for (int i = 0; i < nums.length-2; i++) {
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    res = answer(res, sum, target);
                    right--;
                } else if (sum < target) {
                    res = answer(res, sum, target);
                    left++;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }

    private int answer(int res, int sum, int target) {
        return Math.abs(res - target) < Math.abs(sum - target) ? res : sum;
    }
}





