package gepeng18.leetcode.old;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class L125验证回文串 {
    public static void main(String[] args) {
        final boolean palindrome = new L125验证回文串().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            //先找出有效的字符
            if (!(Character.isLetter(s.charAt(start)) || (Character.isDigit(s.charAt(start))))) {
                start++;
                continue;
            }

            //先找出有效的字符
            if (!(Character.isLetter(s.charAt(end)) || (Character.isDigit(s.charAt(end))))) {
                end--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
                end--;
                start++;
            } else
                return false;

        }
        return true;
    }

}
