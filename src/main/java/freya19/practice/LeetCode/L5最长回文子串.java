package freya19.practice.LeetCode;

import java.util.ArrayList;
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
    // 是否为回文的判断函数
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int len =s.length();
        if(len==0)
            return "";
//        if(len==1)
//            return s;

        String[] memo = new String[len];
        memo[0]=s.substring(0,1);  //substring是前闭后开的
        //对我而言还有一个难点是，怎么从这个字符串中找回文子串
        //状态定义：考虑[0...x]范围里的字符串
        for(int i=1;i<len;i++){
            for(int j=i+1;j<=len;j++){
               if(isPalindrome(s.substring(i,j))) {
                   memo[i]=s.substring(i,j).length()>memo[i-1].length()?s.substring(i,j):memo[i-1];
               }
            }
        }
        return memo[len-1];
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
