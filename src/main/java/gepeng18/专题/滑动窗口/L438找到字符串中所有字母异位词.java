package gepeng18.专题.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 */
public class L438找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        assert (p.length() > 0);

        int[] freqP = new int[26];
        for (int i = 0; i < 26; i++)
            freqP[i] = 0;

        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }

        int[] freqS = new int[26];
        for (int i = 0; i < 26; i++)
            freqS[i] = 0;

        int l = 0, r = -1;
        while (l < s.length()) {

            if (r + 1 < s.length() && r - l + 1 < p.length()) {
                r++;
                freqS[s.charAt(r) - 'a']++;
            } else {
                freqS[s.charAt(l) - 'a']--;
                l++;
            }

            if (r - l + 1 == p.length() && same(freqS, freqP)) {
                res.add(l);
            }
        }

        return res;
    }

    private boolean same(int[] freqS, int[] freqP) {
        for (int i = 0; i < 26; i++)
            if (freqS[i] != freqP[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(new L438找到字符串中所有字母异位词().findAnagrams(s, p));

    }
}
