package freya19.practice.leetcode.回溯;

import java.util.Arrays;

public class L132分割回文串二HARD {
    public int minCut(String s) {
        if(s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp, len-1);
        for(int i = 0; i < len; i++){
            // 注意偶数长度与奇数长度回文串的特点

            // 奇数回文串以1个字符为中心
            mincutHelper(s , i , i , dp);
            // 偶数回文串以2个字符为中心
            mincutHelper(s, i , i+1 , dp);
        }
        return dp[len-1];
    }
    private void mincutHelper(String s, int i, int j, int[] dp){
        int len = s.length();
        while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){

            //这里dp[j]的j，和-1:dp[i-1])+1选择
            dp[j] = Math.min(dp[j] , (i==0?-1:dp[i-1])+1);
            i--;
            j++;
        }
    }
}
