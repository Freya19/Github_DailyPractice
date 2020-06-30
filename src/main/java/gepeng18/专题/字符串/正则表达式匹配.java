package gepeng18.专题.字符串;

/**
 * 假设主串为s，长度为sn， 模式串为p，长度为pn，对于模式串p当前的第i位来说，有'正常字符'、'*'、'.'三种情况。我们针对这三种情况进行讨论：
 *
 *     如果p[i]为正常字符， 那么我们看s[i]是否等于p[i], 如果相等，说明第i位匹配成功,接下来看s[i+1...sn-1] 和 p[i+1...pn-1]
 *
 *     如果p[i] 为'.', 它能匹配任意字符，直接看s[i+1...sn-1] 和 p[i+1...pn-1]
 *
 *     如果p[i] 为'*'， 表明p[i-1]可以重复0次或者多次，需要把p[i-1] 和 p[i]看成一个整体.
 *         如果p[i-1]重复0次，则直接看s[i...sn-1] 和 p[i+2...pn-1]
 *         如果p[i-1]重复一次或者多次,则直接看s[i+1...sn-1] 和p[i...pn-1]，但是有个前提：s[i]==p[i] 或者 p[i] == '.'
 */
public class 正则表达式匹配 {
    public boolean matchStr(char[] str, int i, char[] pattern, int j) {

        // 边界
        if (i == str.length && j == pattern.length) { // 字符串和模式串都为空
            return true;
        } else if (j == pattern.length) { // 模式串为空
            return false;
        }

        boolean flag = false;
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*'); // 模式串下一个字符是'*'
        if (next) {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) { // 要保证i<str.length，否则越界
                return matchStr(str, i, pattern, j + 2) || matchStr(str, i + 1, pattern, j);
            } else {
                return matchStr(str, i, pattern, j + 2);
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return matchStr(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }

    public boolean match(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }
}
