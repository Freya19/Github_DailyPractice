package freya19.practice.算法题和数据结构.动态规划;

import java.util.Arrays;

public class L53最大子序和_动态规划 {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i] --- 第 i 个元素的最大子序和
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            // 以第 i 个元素结尾的最大子序和 ===>
            // 以 第 i-1个元素结尾 时的最优解：
            // dp[i-1]>0,则dp[i - 1] + nums[i]；否则 nums[i]。其中留下最大的
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            if (maxSum < dp[i]) {
                maxSum = dp[i];
            }
        }

        return maxSum;
    }
}
