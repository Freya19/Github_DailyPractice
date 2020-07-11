package freya19.practice.动态规划;

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
public class L70ClimbStairs动态规划 {
    public int climbStairs(int n) {

        int[] memo = new int[n+1];
//        Arrays.fill(memo,-1);

        memo[0]=1;
        memo[1]=1;
        for(int i=2;i<=n;i++){
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        // 注意：题目中要求给定 n 是一个正整数。
        int n=1;
        L70ClimbStairs动态规划 cs = new L70ClimbStairs动态规划();
        System.out.println(cs.climbStairs(n));
    }
}
