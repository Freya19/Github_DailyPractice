package gepeng18.专题.字符串;

import java.util.HashSet;

/**
 * LeetCode: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * <p>
 * 我们上面已经知道了什么是回文串？现在我们考虑一下可以构成回文串的两种情况：
 * <p>
 * 字符出现次数为双数的组合
 * 字符出现次数为偶数的组合+单个字符中出现次数最多且为奇数次的字符 （参见 issue665 ）
 * <p>
 * 统计字符出现的次数即可，双数才能构成回文。因为允许中间一个数单独出现，比如“abcba”，
 * 所以如果最后有字母落单，总长度可以加 1。首先将字符串转变为字符数组。然后遍历该数组，判
 * 断对应字符是否在hashset中，如果不在就加进去，如果在就让count++，然后移除该字符！这样就能找到出现次数为双数的字符个数。
 */
public class 构造最长回文串 {

    public int longestPalindrome(String s) {
        if (s.length() == 0)
            return 0;
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            // 如果hashset没有该字符就保存进去
            if (!hashset.contains(chars[i])) {
                hashset.add(chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                count++;
            }
        }
        /**
         * 题目意思为构成的回文串的长度，所以空则表明加加减减正好全部取消，不为空则从中随便抽出一个作为中心，
         * 那么就是2n+1
         */
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
