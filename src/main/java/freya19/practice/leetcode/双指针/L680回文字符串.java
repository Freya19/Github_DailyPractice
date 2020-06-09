package freya19.practice.leetcode.双指针;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1: 输入: "aba";  输出: True
 * <p>
 * 示例 2:输入: "abca";   输出: True
 * 解释: 你可以删除c字符。
 */

public class L680回文字符串 {
    public boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;

//        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
//            }
//        }
//        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "abca";
        boolean b = new L680回文字符串().validPalindrome(s);
        System.out.println(b);
    }
}

