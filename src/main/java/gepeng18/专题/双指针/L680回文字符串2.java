package gepeng18.专题.双指针;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 */
public class L680回文字符串2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return isPalindrome(s, left, right-1) || isPalindrome(s, left+1, right);
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
