package gepeng18.专题.动态规划;

public class L72编辑距离 {
    int dp[][];

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
         dp = new int[n1 + 1][n2 + 1];

        //常规初始化
        for(int i=0;i<n1+1;i++)
            for(int j=0;j<n2+1;j++)
                dp[i][j] = -1;
        dp[0][0] = 0;
        //题解初始化
        // dp[0][0...n2]的初始值
        for (int j = 1; j <= n2; j++)
            dp[0][j] = dp[0][j - 1] + 1;
        // dp[0...n1][0] 的初始值
        for (int i = 1; i <= n1; i++)
            dp[i][0] = dp[i - 1][0] + 1;

        return solution(word1,word2,n1,n2);
    }
    public int solution(String word1,String word2,int m,int n){
        if(dp[m][n]!=-1)
            return dp[m][n];
        int res;
        // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
        if (word1.charAt(m - 1) == word2.charAt(n - 1)){
            res = solution(word1,word2,m-1,n-1);
        }else {
            res = Math.min(
                    Math.min(solution(word1,word2,m-1,n-1), solution(word1,word2,m,n-1)),
                    solution(word1,word2,m-1,n))
                  + 1;
        }
        dp[m][n] = res;
        return res;
    }

    public static void main(String[] args) {
        new L72编辑距离().minDistance("horse","ros");
    }
}
