package gepeng18.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public static String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0;

        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                stringBuilders[i].append(s.charAt(index));
                index++;
            }
            for (int i = numRows - 2; i > 0 && index < s.length(); i--) {
                stringBuilders[i].append(s.charAt(index));
                index++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j < stringBuilders[i].length(); j++) {
                result.append(stringBuilders[i].charAt(j));
            }
        }
        return result.toString();
    }
}

public class ZFormConvertL6 {
    public static void main(String[] args) {
        String data = "LEETCODEISHIRING";
        String result = Solution.convert(data, 3);
        System.out.println(result);
    }
}
