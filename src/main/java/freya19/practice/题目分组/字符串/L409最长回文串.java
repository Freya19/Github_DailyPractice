package freya19.practice.题目分组.字符串;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 输入:"abccccdd"      输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */

public class L409最长回文串 {
    public int longestPalindrome(String s) {

        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }

        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome += (cnt / 2) * 2;
        }

        if (palindrome < s.length()) {
            palindrome++;
        }

        return palindrome;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        int i = new L409最长回文串().longestPalindrome(s);
        System.out.println(i);
    }
}
