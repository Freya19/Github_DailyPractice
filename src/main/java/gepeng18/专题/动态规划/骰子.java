package gepeng18.专题.动态规划;

public class 骰子 {
    static int solve(int n) {
        int dp[][] = new int[n+1][(n+1)*6];
        for (int i = 1; i <= 6; i ++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i ++) {
            for (int j = i; j <= 6*i; j ++) {
                for (int cur = 1; cur <= 6; cur ++) {
                    if (j - cur <= 0) {
                        break;
                    }
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }

        int sum = 0;
        for (int i = 1;i<=n;i++)
            sum += dp[i][n];
        return sum;
    }

    public static void main(String[] args) {
        int i = solve(3);
        System.out.println(i);
    }
}
