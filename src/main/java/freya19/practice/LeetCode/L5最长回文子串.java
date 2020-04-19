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
    private String res = "";

    public String longestPalindrome(String s) {
        //先将传入的s处理好，再调用中心扩展法找
        if (s.length() == 0)
            return s;

        //加#
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            newStr.append("#").append(s.charAt(i));
        String newS = newStr.append("#").toString();

        //调用中心扩展函数找回文串
        for (int i = 0; i < newS.length(); i++) {
            centerExpand(newS, i);
        }

        //找到后去#
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '#')
                resStr.append(res.charAt(i));
        }
        return resStr.toString();
    }

    //中心扩展法
    private String centerExpand(String str, int cur) {
        int l = cur;
        int r = cur;

        while (l - 1 >= 0 && r + 1 < str.length() && str.charAt(l - 1) == str.charAt(r + 1)) {
            l--;
            r++;
            res = res.length() > str.substring(l, r + 1).length() ? res : str.substring(l, r + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "babad";
        String s = "bb";
        L5最长回文子串 l5 = new L5最长回文子串();
        String s1 = l5.longestPalindrome(s);
        System.out.println(s1);
    }
}
