package gepeng18.专题.动态规划.L279;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */


public class 完全平方数 {
    int dp[];

    //n时的最小个数
    public int numSquares(int n) {
        dp = new int[n];
        Arrays.fill(dp, -1);

        findRes(n);
    }

    private int findRes(int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            final int subMin = findRes((int) (n - Math.pow(i, 2)));
            if (subMin >= 0 && subMin < Integer.MAX_VALUE)
                min = Math.min(min, subMin);
        }
        if(min<Integer.MAX_VALUE)
            dp[n] = min;
        return dp[n];
    }
}
