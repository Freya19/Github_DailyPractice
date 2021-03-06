package freya19.practice.算法题和数据结构.动态规划;

/**
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
public class L343IntegerBreak动态规划 {
    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
    public int integerBreak(int n) {
        assert(n>=2);

        // 存放最大乘积的数组
        int[] memo = new int[n+1];

        // 循环递推 —— 分隔，找最大乘积
        memo[1]=1;
        for(int i=2;i<=n;i++)   // 注意<= 临界的问题
            // memo[i]
            for(int j=1;j<=i-1;j++)    // 注意<= 临界的问题
                // 将i 分隔成 j+(i-j), 然后找最大乘积
                memo[i]= max3(memo[i],j*(i-j),j*memo[i-j]);
//                memo[i]= max(memo[i],j*(i-j),j*memo[i-j]); //import static sun.swing.MenuItemLayoutHelper.max;也许LeetCode没法导入这个包
            return memo[n];
    }

    public static void main(String[] args) {
        L343IntegerBreak动态规划 ib = new L343IntegerBreak动态规划();
        System.out.println(ib.integerBreak(3));
    }
}
