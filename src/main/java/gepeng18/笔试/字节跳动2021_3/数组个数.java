package gepeng18.笔试.字节跳动2021_3;

import java.util.Scanner;

/**
 * https://www.cnblogs.com/quanjun/p/12205607.html
 */
public class 数组个数 {
    int maxn = 200001;
    long dp[][] = new long[maxn][3];
    public long solve(int n, int l, int r){
        dp[0][0] = 1;
        for (int i = 1;i<=n;i++){
            for (int j = 0;j<3;j++){
                long num = (r+j)/3-(l-1+j)/3;
                for (int k =0;k<3;k++){
                    dp[i][(k+j)%3] = (dp[i][(k+j)%3]+dp[i-1][k]*num)%1000000007L;
                }
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int l = input.nextInt();
        int r = input.nextInt();

        long solve = new 数组个数().solve(n, l, r);
        System.out.println(solve);
    }
}
