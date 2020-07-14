package freya19.practice.算法题和数据结构.字符串;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:输入: 121     输出: true
 * 不将 整数 转为 字符串 来解决这个问题
 */
public class L9回文数字 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }

        return x == right || x == right / 10;
    }

    public static void main(String[] args) {
        int i=100;
        boolean palindrome = new L9回文数字().isPalindrome(i);
        System.out.println(palindrome);

    }
}
