package freya19.practice.算法题和数据结构.动态规划;

import java.util.Arrays;

public class SO10斐波那契数列EasyN {

    int[] dp;

    public int fib(int n) {
        if (n < 1) {
            return n;
        }
        // 初始化
        // 1. 常规初始化
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // 2. 特殊初始化 ----  边界条件or动态转移方程的起始值
        dp[0] = 0;
        dp[1] = 1;

        return getFib(n);
    }

    private int getFib(int n) {
        if (dp[n] == -1) {
            dp[n] = getFib(n - 2) + getFib(n - 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
