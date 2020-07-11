package freya19.practice.动态规划;

import java.util.Arrays;

/**
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。

示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
public class L70ClimbStairs记忆化搜索 {

    int[] memo;

    public int climbStairs(int n) {

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return calculatedWays(n);
    }

    private int calculatedWays(int n) {
        if (n == 0 || n == 1)
            return 1;

        if (memo[n] == -1)
            //感觉这就是个递归调用的过程
            memo[n] = calculatedWays(n - 1) + calculatedWays(n - 2);
        // 但是加上判断memo[n]是不是-1，就有个记忆化的过程，也就是重复的子问题，不会再计算一遍了，直接返回
        return memo[n];
    }


    public static void main(String[] args) {
        // 注意：题目中要求给定 n 是一个正整数。
        int n = 3;
        L70ClimbStairs记忆化搜索 cs = new L70ClimbStairs记忆化搜索();
        System.out.println(cs.climbStairs(n));
    }
}
