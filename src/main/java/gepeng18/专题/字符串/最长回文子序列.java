package gepeng18.专题.字符串;

/**
 * 4.4. 最长回文子序列
 * <p>
 * LeetCode: 最长回文子序列 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * 最长回文子序列和上一题最长回文子串的区别是，子串是字符串中连续的一个序列，而子序列是字符串中保持相对位置的字符序列，
 * 例如，"bbbb"可以是字符串"bbbab"的子序列但不是子串。
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 动态规划： dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
 * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
 */
public class 最长回文子序列 {


    public int longestPalindromeSubseq1(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }

    private int dp[][];

    //返回s的最长回文子串的长度
    public int longestPalindromeSubseq2(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }

        int res = solution(s, 0, s.length() - 1);

        return res;
    }

    //返回s从left到right的最长回文子串的长度
    public int solution(String s, int left, int right) {
        if (dp[left][right] != -1)
            return dp[left][right];

        if (left == right-1) {
            int res;
            if (s.charAt(left) == s.charAt(right))
                res = 2;
            else
                res = 1;

            dp[left][right] = res;
            return res;
        }

        if (left == right) {
            dp[left][right] = 1;
            return dp[left][right];
        }

        int res;
        if (s.charAt(left) == s.charAt(right))
            res = solution(s, left + 1, right - 1) + 2;
        else
            res = Math.max(solution(s, left + 1, right ),solution(s, left , right - 1));
        dp[left][right] = res;
        return res;
    }

    public static void main(String[] args) {
         int bbbab = new 最长回文子序列().longestPalindromeSubseq2("bbbab");
        System.out.println(bbbab);
    }

}
