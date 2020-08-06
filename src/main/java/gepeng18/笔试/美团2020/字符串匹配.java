package gepeng18.笔试.美团2020;

import java.util.*;

public class 字符串匹配 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String s = sc.next();
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // i 是原串索引，j是目标串索引
        for(int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        // dp[x][0] 都是 false 原串非空 匹配串是空 肯定不行
        // i 和 j的状况下，如果i-1 j-1相等 或者 两者不等但j-1 == ？。都可以直接通过前一步获得
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*'){
                    // i 和 j的状况下，如果j-1是*,则 分为匹配或者不匹配  不匹配 则 [i][j-1] 或者 匹配 [i-1][j]
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        System.out.println((dp[m][n] ? 1 : 0));
    }
}
