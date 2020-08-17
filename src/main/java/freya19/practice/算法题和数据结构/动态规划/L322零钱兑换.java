package freya19.practice.算法题和数据结构.动态规划;

import java.util.Arrays;

public class L322零钱兑换 {
    /**
     * 使用最少的张数兑换零钱
     *
     * @param coins  不同面值的钱
     * @param amount 需要兑换的金额
     * @return 最少的张数
     */
    public int coinChange(int[] coins, int amount) {

        // dp[]中存储金额1至金额amount的最优解（最少的张数兑换零钱）
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        //  0元兑换 其最优解是0 (所以dp的索引 就是具体要换的 钱)
        dp[0] = 0;

        // i 代表要换的钱； coins[]存储的是不同面值的零钱，j就是单纯的索引
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // i - coins[j] 表示用了coins[j]面值的零钱后剩下的钱 >0就表示还要继续兑换 （比如 14-10 = 4）
                // dp[i - coins[j]] != -1  表示剩的这个未兑换的金额，有过最优解 （即 dp[4] 有最优解）
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    // i 金额的钱没用兑换最优解 或者 它的最优解比它的子问题最优解差（兑换的零钱张数比子问题的多）
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        // 则覆盖金额 i 的最优解
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }

        return dp[amount];
    }
}
