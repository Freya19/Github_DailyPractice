package gepeng18.专题.动态规划;

import java.sql.SQLOutput;

public class L64最小路径和 {
    int [][] dp;

    public int minPathSum(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }

        dp = new int[m][n]; //

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                dp[i][j] = -1;
        // 初始化
        dp[0][0] = arr[0][0];
        // 初始化最左边的列
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        // 初始化最上边的行
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        return solution(arr,m-1,n-1);
    }

    public int solution(int [][] arr,int m,int n){
        if(dp[m][n]!=-1)
            return dp[m][n];

        int res = Math.min(solution(arr,m-1,n),solution(arr,m,n-1))+arr[m][n];
        dp[m][n] = res;

        return res;

    }

    public static void main(String[] args) {
        int [][]arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(new L64最小路径和().minPathSum(arr));
    }
}
