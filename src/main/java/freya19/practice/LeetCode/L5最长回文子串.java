package freya19.practice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：

输入: "babad"     输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"      输出: "bb"
 */
public class L5最长回文子串 {
    private String[] memo;

    // 是否为回文的判断函数
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //考虑[0...s.length)长度的字符串所能得到的最长回文子串
    public String longestPalindrome(String s) {
        memo = new String[s.length()];
        Arrays.fill(memo, "-1");

        return findLongestPalindrome(s, 0);
    }

    //考虑[index...s.length)长度的字符串所能得到的最长回文子串
    private String findLongestPalindrome(String s, int index) {
        if (index >= s.length())
            return "";

        if (memo[index].equals("-1"))
            return memo[index];

        String res = "0";
        for (int i = index; i < s.length(); i++) {
            //判断是不是回文
            String tmp = findLongestPalindrome(s, i + 1);
            if (isPalindrome(tmp))
                //判断下一个回文子串和当前回文子串哪个长
                res = res.length() > findLongestPalindrome(s, i + 1).length() ? res : findLongestPalindrome(s, i + 1);
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {
//        String s = "babad";
//        System.out.println(s.substring(0, 1));
        String s = "bb";
        L5最长回文子串 l5 = new L5最长回文子串();
        String s1 = l5.longestPalindrome(s);
        System.out.println(s1);
    }
}
