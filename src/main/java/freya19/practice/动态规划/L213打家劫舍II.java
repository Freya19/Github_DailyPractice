package freya19.practice.动态规划;

import java.util.Arrays;

/**
 * 环形街区打家劫舍
 * 状态转移方程： dp[n+1]=max(dp[n],dp[n−1]+num)
 */
public class L213打家劫舍II {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(myRob(nums, 0, nums.length - 1), myRob(nums, 1, nums.length));
    }

    private int myRob(int[] nums, int left, int right) {
        int pre = 0, cur = 0, tmp;
        for (int i = left; i < right; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr={2,1,1,2};
        int rob = new L213打家劫舍II().rob(arr);
        System.out.println(rob);
    }
}
