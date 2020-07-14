package freya19.practice.算法题和数据结构.字符串;

import java.util.HashMap;
import java.util.Set;

public class SO50第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        char res = ' ';
        if (s == null || s.length() == 0) {
            return res;
        }

        HashMap<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (cntMap.get(c) == 1) {
                res = c;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char ret = new SO50第一个只出现一次的字符().firstUniqChar("leetcode");
        System.out.println(ret);
    }
}
