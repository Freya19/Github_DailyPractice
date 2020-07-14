package freya19.practice.算法题和数据结构.动态规划;

public class L62不同路径 {
    int[][] dp;

    public int uniquePaths(int m, int n) {

        if (m <= 0 || n <= 0) {
            return 0;
        }

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        return solution(m - 1, n - 1);
    }

    public int solution(int m, int n) {
        if (dp[m][n] == -1) {
            dp[m][n] = solution(m - 1, n) + solution(m, n - 1);
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new L62不同路径().uniquePaths(3, 2));
    }
}
