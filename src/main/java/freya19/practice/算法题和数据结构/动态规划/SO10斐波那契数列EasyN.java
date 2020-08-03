package freya19.practice.算法题和数据结构.动态规划;

import java.util.Arrays;

public class SO10斐波那契数列EasyN {

    int[] dp;

    public int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return getFib(n);
    }

    private int getFib(int n) {

        if(n==0){
            dp[0] = 0;
            return 0;
        }

        if(n==1){
            dp[1] = 1;
            return 1;
        }

        if (dp[n] == -1) {
            dp[n] = getFib(n - 1) + getFib(n - 2);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int fib = new SO10斐波那契数列EasyN().fib(45);
        System.out.println(fib);
    }
}
