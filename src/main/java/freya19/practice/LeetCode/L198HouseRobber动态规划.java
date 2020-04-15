package freya19.practice.LeetCode;
/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
能够偷窃到的最高金额。

示例 1:
输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2:
输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

import java.util.Arrays;


public class L198HouseRobber动态规划 {
    /**
     * 考虑偷[x...n-1]范围内的房子
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        // 这里是倒过来思考的，从最后一个房子开始偷
        memo[n - 1] = nums[n - 1]; // n-1 是最后一间房子

        // memo[i]就是打劫nums[i...n-1]个房子中的部分房子所能得到的最大金钱
        for (int i = n - 2; i >= 0; i--)   // 0 ≤ i ≤ n-2
            for (int j = i; j < n; j++)    // n-2 ≤ j < n         所以 合在一起就是 [0...n-1]范围内的房子
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
        return memo[0];
    }

    /**
     * 考虑偷[0...x]范围内的房子
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        memo[0] = nums[0];
        for (int i = 1; i < n; i++)
            for (int j = i; j >= 0; j--)
                memo[i] = Math.max(memo[i], nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0));
        return memo[n-1];
    }
}
