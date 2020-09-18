package gepeng18.专题.动态规划.子串和子序列;

import java.util.Arrays;

// 最长公共子序列长度
public class 最长公共子序列长度 {
    private int[][] memo;

    public int lcs(String s1, String s2){

        if(s1 == null || s2 == null)
            throw new IllegalArgumentException("s1 and s2 can not be null.");

        if(s1.length() == 0 || s2.length() == 0)
            return 0;

        memo = new int[s1.length()][s2.length()];
        for(int i = 0 ; i < s1.length() ; i ++)
            Arrays.fill(memo[i], -1);

        return lcs(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    // 求s1[0...m]和s2[0...n]的最长公共子序列的长度值
    private int lcs(String s1, String s2, int m, int n){

        if(m < 0 || n < 0)
            return 0;

        if(memo[m][n] != -1)
            return memo[m][n];

        int res = 0;
        if(s1.charAt(m) == s2.charAt(n))
            res = 1 + lcs(s1, s2, m - 1, n - 1);
        else
            res = Math.max(lcs(s1, s2, m - 1, n),
                    lcs(s1, s2, m, n - 1));

        memo[m][n] = res;
        return res;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println((new 最长公共子序列长度()).lcs(s1, s2));

    }
}
