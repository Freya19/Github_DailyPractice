package freya19.practice.算法题和数据结构.动态规划;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
 */

public class L62机器人不同路径 {
    private int[][] dp;

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;

        //创建并初始化数组
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        //特殊初始化
        // 最上边
        for (int j = 0; j < n; j++)
            //到最上面任何一个点都是1条路径
        {
            dp[0][j] = 1;
        }

        for (int i = 0; i < m; i++)
            //到最左侧任何一个点都是1条路径
        {
            dp[i][0] = 1;
        }

        //一般的情况，就调用已经写好的函数
        return findUniquePaths(m - 1, n - 1);
    }

    private int findUniquePaths(int m, int n) {
        if(dp[m][n]!=-1)
            return dp[m][n];

        //其实res就是dp[m][n]
        int res = findUniquePaths(m,n-1)+findUniquePaths(m-1,n);
        dp[m][n]=res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L62机器人不同路径().uniquePaths(3,2));
    }
}
