package freya19.practice.算法题和数据结构.动态规划;

/**
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class L64最小路径和 {
    //记录最小路径和
    int[][] dp;

    public int minPathSum(int[][] grid) {
        //获取grid的行数和列数
        //行数
        int m = grid.length;
        //列数
        int n = grid[0].length;

        //条件判断
        if (m <= 0 || n <= 0) {
            return 0;
        }

        //创建dp并初始化
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        //边界的情况
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            //首列
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            //首行
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        //一般的情况，直接调用写好的函数
        return findMinPathSum(grid, m - 1, n - 1);
    }

    private int findMinPathSum(int[][] arr, int m, int n) {
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int res = Math.min(findMinPathSum(arr, m - 1, n), findMinPathSum(arr, m, n - 1)) + arr[m][n];
        dp[m][n] = res;

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
        System.out.println(new L64最小路径和().minPathSum(arr));
    }
}
