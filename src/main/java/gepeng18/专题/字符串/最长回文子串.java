package gepeng18.专题.字符串;

/**
 * 4.3. 最长回文子串
 *
 *     Leetcode: LeetCode: 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度。给大家大致花了个草图，不要嫌弃！
 */
public class 最长回文子串 {

    private int index, len;

    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            //以i为中心向两边扩
            palindromeHelper(s, i, i);
            //以i，i+1为中心向两边扩
            palindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }

    public void palindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        //长度就是r-l+1，但是l--了，r++了，所以多了2，所以是r-l-1
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }
}

