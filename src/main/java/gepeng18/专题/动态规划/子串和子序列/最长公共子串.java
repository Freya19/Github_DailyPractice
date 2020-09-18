package gepeng18.专题.动态规划.子串和子序列;

public class 最长公共子串 {
    public void findLength(int[] A, int[] B){
        int[][] dp = new int[A.length][B.length];
        int max = 0;
        //初始化第一行
        for(int j = 0; j < B.length; j++){
            if(A[0] == B[j]) dp[0][j] = 1;
        }
        //初始化第一列
        for(int i = 0; i < A.length; i++){
            if(A[i] == B[0]) dp[i][0] = 1;
        }

        //dp
        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < B.length; j++){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
//        return max;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(dp[i][j] == max){
                    for(int k = i - max + 1; k <= i; k++){
                        System.out.print(A[k]+ " ");
                    }
                }
            }
        }
    }

}
