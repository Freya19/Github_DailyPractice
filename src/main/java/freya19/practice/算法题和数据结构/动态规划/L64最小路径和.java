package freya19.practice.算法题和数据结构.动态规划;

public class L64最小路径和 {

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;

        // 记录最优解的数组 —— 最小路径和
        int[][] dp = new int[rows][cols];
        // 原始初始化
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }

        // 边界初始化
        dp[0][0] = grid[0][0];

        // 1. 左列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 2. 上边
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 动态转移方程
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }

        public static void main(String[] args) {
            int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    //        System.out.println(arr.length);
    //        System.out.println(arr[0].length);
            System.out.println(new L64最小路径和().minPathSum(arr));
        }
}
