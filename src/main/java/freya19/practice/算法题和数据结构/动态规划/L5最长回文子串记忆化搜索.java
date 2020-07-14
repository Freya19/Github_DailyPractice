package freya19.practice.算法题和数据结构.动态规划;

/**
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：

输入: "babad"     输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"      输出: "bb"
 */
public class L5最长回文子串记忆化搜索 {

    /**
     *  记忆数组 —— 记录回文
     */
    private int[][] dp;

    /**
     * 最终的结果 —— 最长的回文子串
     */
    private String maxString = "";

    public String longestPalindrome(String s) {
        // 创建记忆数组，并初始化
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }

        //一个个子串开始判断（直接调用写好的判断函数）
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++)
                findlongestPalindrome(s, i, j);
        return maxString;
    }

    private int findlongestPalindrome(String s, int l, int r) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        // 初始化特殊位置的值
        // l和r指向同一个位置，那么肯定是回文
        if (l==r){
            maxString =s.substring(l,r+1).length()>maxString.length()?s.substring(l,r+1):maxString;
            dp[l][r]=1;
            return dp[l][r];
        }

        //如果l和r相邻，如果字符相等就是回文
        if(l==r+1){
            if (s.charAt(l) == s.charAt(r)) {
                maxString =s.substring(l,r+1).length()>maxString.length()?s.substring(l,r+1):maxString;
                dp[l][r]=1;
            }else {
                dp[l][r]=0;
            }

            return dp[l][r];
        }

        //递归考虑普通的情况
        //当前元素值相等，并且[l+1,r-1]字符串是回文
        if(s.charAt(l)==s.charAt(r)&&findlongestPalindrome(s,l+1,r-1)==1){
            maxString=s.substring(l,r+1).length()>maxString.length()?s.substring(l,r+1):maxString;
            dp[l][r]=1;
        }else
            dp[l][r]=0;

        return dp[l][r];
    }


    public static void main(String[] args) {
        String s = "babad";
//        String s = "bb";
        L5最长回文子串记忆化搜索 l5 = new L5最长回文子串记忆化搜索();
        String s1 = l5.longestPalindrome(s);
        System.out.println(s1);
    }
}
