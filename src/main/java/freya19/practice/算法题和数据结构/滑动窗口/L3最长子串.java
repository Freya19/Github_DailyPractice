package freya19.practice.算法题和数据结构.滑动窗口;
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


import java.util.HashMap;
import java.util.Map;

public class L3最长子串 {
    public int lengthOfLongestSubstring(String s) {

        int start = 0, end = 0, res = 0; //res记录的是子串的长度
        //key为end此时对于的字符，value为end+1（就是下一个索引位置，这个位置是不重复的字符）
        Map<Character, Integer> map = new HashMap<>();
        int len =s.length();
        while (end<len){
            char c = s.charAt(end);
            if(!map.containsKey(c)){
                map.put(c,end+1);
                res = Math.max(res,end-start+1);
                end++;
            }else {
                start=Math.max(start,map.get(c)); //此时start指向不重复字符 因为map必然会存了重复的字符，所以需要get最新的这个字符
//                start=map.get(c); //此时start指向之前重复字符的下一个字符    abba就会错误
                map.put(c,end+1);
                res = Math.max(res,end-start+1);
                end++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "";
        String s4 = "dvdf";
        String s5 = "pwwkew";

        L3最长子串 l3 = new L3最长子串();
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
