package freya19.practice.LeetCode;
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"      输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"     输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"    输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。

"" 返回0；
" " 返回1；

请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */


import java.util.ArrayList;
import java.util.List;

public class L3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int resLen = 0;
        if (s.equals("")) return 0;
        if (s.equals(" ")) return 1;

        int i = 0, j = 0, len = s.length();
        List<Character> list = new ArrayList<>();
        while (i < len) {

            char c = s.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
                i++;
            } else {
                resLen = Math.max(resLen, list.size());
                j = s.lastIndexOf("c", i - 1) + 1; //最近的一个重复字符索引的后一位，给j

                list.clear();
                for (int k = j; k <= i; k++) {
                    list.add(s.charAt(k));
                }
                i++;
            }
        }

        resLen = Math.max(resLen,list.size());
        return resLen;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "";
        String s4 = "dvdf";
        String s5 = "pwwkew";

        L3无重复字符的最长子串 l3 = new L3无重复字符的最长子串();
        System.out.println(l3.lengthOfLongestSubstring(s1));
        System.out.println(l3.lengthOfLongestSubstring(s2));
        System.out.println(l3.lengthOfLongestSubstring(s3));
        System.out.println(l3.lengthOfLongestSubstring(s4));
        System.out.println(l3.lengthOfLongestSubstring(s5));


    }


//        System.out.println(s2.lastIndexOf("d", 1));
//        System.out.println(s2.isEmpty());   //false
//        System.out.println(s2.length());    //1
}
