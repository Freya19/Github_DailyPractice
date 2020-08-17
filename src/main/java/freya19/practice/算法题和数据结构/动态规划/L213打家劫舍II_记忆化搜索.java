package freya19.practice.算法题和数据结构.动态规划;

import java.util.Arrays;

/**
 * 环形街区打家劫舍
 * 状态转移方程： dp[n+1]=max(dp[n],dp[n−1]+num)
 */
public class L213打家劫舍II_记忆化搜索 {

    private int[] dp02;
    private int[] dp11;

    public int rob(int[] nums) {

        int end = nums.length - 1;
        dp02 = new int[end + 1];
        dp11 = new int[end + 1];
        Arrays.fill(dp02, -1);
        Arrays.fill(dp11, -1);

        return Math.max(tryRobZeroToEnd2(nums, end - 1), tryRobOneToEnd1(nums, end ));
    }

    private int tryRobZeroToEnd2(int[] nums, int end) {
        if (nums==null||nums.length==0||end >= nums.length)  {
            return 0;
        }

        if (end == 0) {
            return nums[0];
        }

        if (end == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if (end == 2) {
            return Math.max(nums[1], nums[0] + nums[2]);
        }

        if (dp02[end] != -1) {
            return dp02[end];
        }

        // 偷前一个 和 当前的+前2个 中最大的
        int res = Math.max(tryRobZeroToEnd2(nums, end - 1), nums[end] + tryRobZeroToEnd2(nums, end - 2));
        dp02[end] = res;
        return res;
    }

    private int tryRobOneToEnd1(int[] nums, int end) {
        if (nums==null||nums.length==0||end >= nums.length) {
            return 0;
        }

        if (end == 1) {
            return nums[1];
        }

        if (end == 2) {
            return Math.max(nums[1], nums[2]);
        }

        if (dp11[end] != -1) {
            return dp11[end];
        }

        // 偷前一个 和 当前的+前2个 中最大的
        int res = Math.max(tryRobOneToEnd1(nums, end - 1), nums[end] + tryRobOneToEnd1(nums, end - 2));
        dp11[end] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 3, 4};
        int rob = new L213打家劫舍II_记忆化搜索().rob(arr);
        System.out.println(rob);
    }
}
