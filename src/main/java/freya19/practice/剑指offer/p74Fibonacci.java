package freya19.practice.剑指offer;

import java.util.Arrays;

public class p74Fibonacci {
    public int Fibonacci(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);  // 赋初值

        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        p74Fibonacci f = new p74Fibonacci();
        System.out.println(f.Fibonacci(n));

    }
}
