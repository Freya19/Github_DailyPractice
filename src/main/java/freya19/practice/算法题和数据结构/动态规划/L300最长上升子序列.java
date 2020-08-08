package freya19.practice.算法题和数据结构.动态规划;

import java.util.Arrays;

public class L300最长上升子序列 {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }

        // 初始化
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        int maxLength = 1;
        dp[0] = 1;

        // 第i个元素
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            // 0到 i-1个元素
            for (int j = 0; j < i; j++) {
                // 如果 第 i个元素 大于 前面 0 到 i-1 个元素中的某些元素
                // 则 可以加入到最长上升子序列中，即最长上升子序列长度 加 1
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            if (maxLength < dp[i]) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }
}
