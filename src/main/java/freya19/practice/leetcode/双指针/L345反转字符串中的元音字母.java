package freya19.practice.leetcode.双指针;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 为了快速判断一个字符是不是元音字符，将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 */

public class L345反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        if (s == null) {
            return null;
        }

        char[] res = new char[s.length()];
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if(!vowels.contains(cl)){
                res[l++]=cl;
            }else if(!vowels.contains(cr)){
                res[r--]=cr;
            }else {
                res[r--]=cl;
                res[l++]=cr;
            }
        }
        return new String(res);
    }
}
