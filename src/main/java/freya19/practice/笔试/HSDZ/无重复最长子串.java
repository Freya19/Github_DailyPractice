package freya19.practice.笔试.HSDZ;

import java.util.HashMap;

public class 无重复最长子串 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 找到输入字符串中连续不含重复字符的最长子串。如果有多个相同长度的，只需取第一个。
     *
     *  用hashmap可以100%，用 双指针 只能过一半。
     *
     * @param str string字符串 非空字符串
     * @return string字符串
     */
    public String findMaxSubstr(String str) {
        // write code here

        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        int max = 0, l = 0;
        String res = null;

        for (int r = 0; r < str.length(); r++) {
            if (dict.containsKey(str.charAt(r))) {
                l = Math.max(l, dict.get(str.charAt(r)) + 1);
            }
            dict.put(str.charAt(r), r);
            if (r - l + 1 > max) {
                max = Math.max(max, r - l + 1);
                res = str.substring(l, r + 1);
            }
        }
        return res;
    }


    class Solution1 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 找到输入字符串中连续不含重复字符的最长子串。如果有多个相同长度的，只需取第一个。
         *
         * @param str string字符串 非空字符串
         * @return string字符串
         */
        public String findMaxSubstr(String str) {
            // write code here
            int[] freq = new int[256];

            int l = 0, r = -1;
            int res = 0;
            String resStr = null;

            while (l < str.length()) {
                if (r + 1 < str.length() && freq[str.charAt(r + 1)] == 0) {
                    r++;
                    freq[str.charAt(r)]++;
                } else {
                    freq[str.charAt(l)]--;
                    l++;
                }

                if (r - l + 1 > res) {
                    res = Math.max(res, r - l + 1);
                    resStr = str.substring(l, r + 1);
                }
            }

            return resStr;
        }
    }
}