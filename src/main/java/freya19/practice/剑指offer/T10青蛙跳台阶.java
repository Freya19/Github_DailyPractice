package freya19.practice.剑指offer;

import java.util.Arrays;

public class T10青蛙跳台阶 {
    int[] dp;

    public int numWays(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        dp[1] = 1;

        return getNumWays(n);
    }

    private int getNumWays(int n) {
        if (dp[n] == -1) {
            dp[n] = getNumWays(n - 2) + getNumWays(n - 1);
        }
        return dp[n];
    }
}
