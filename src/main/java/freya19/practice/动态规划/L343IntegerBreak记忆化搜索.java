package freya19.practice.动态规划;

import java.util.Arrays;

/*
给定一个正整数 n，将其拆分为至少两个正整数的和，
并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。

示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class L343IntegerBreak记忆化搜索 {

    private int[] memo;

    public int integerBreak(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n must >=1 !");

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return breakInteger(n);
    }

    //将n进行分割，至少分成两份，可获得的 最大乘积
    private int breakInteger(int n) {
        if (n == 1)
            return 1;

        if (memo[n] != -1)
            return memo[n];

        int res = -1;
        for (int i = 1; i < n ; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }

        memo[n] = res;
        return res;

//        酱紫不行哦
//        if (memo[n] == -1) {
//            for (int i = 0; i < n-1; i++) {
//                memo[i] = max3(memo[i], i * (n - i), i * memo[n - i]);
//            }
//        }
//        return memo[n];

    }

    //三数中的最大值
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        L343IntegerBreak记忆化搜索 ib = new L343IntegerBreak记忆化搜索();
        System.out.println(ib.integerBreak(2));
        System.out.println(ib.integerBreak(10));
    }
}
