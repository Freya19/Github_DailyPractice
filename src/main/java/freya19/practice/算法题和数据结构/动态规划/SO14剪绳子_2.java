package freya19.practice.算法题和数据结构.动态规划;

import java.util.Arrays;

public class SO14剪绳子_2 {
    public int cuttingRope(int n) {
        if (n <= 1) {
            return n;
        }

        // dp[i]表示 绳子长度为i时可以剪成的各段长度最大乘积
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]=Math.max(dp[i],Math.max(i*(i-j),dp[i-j]));
            }
        }
        return dp[n];
    }
}
