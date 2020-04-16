package gepeng18.专题.动态规划;



import java.util.Arrays;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class L5最长回文串_错误 {
    private String maxString = "";
    private int[][] isHui; //0 不是 1 是  -1  没算

    //判断start-end是否是一个回文串
    public int longestPalindrome(String s, int start, int end) {
        if(end==start+1||end==start)
            if (s.charAt(start) == s.charAt(end)) {
                isHui[start][end] = 1;
                maxString = maxString.length()>end - start + 1?maxString:s.substring(start,end+1);
                return 1;
            } else{
                isHui[start][end] = 0;
                return 0;
            }


        if (isHui[start + 1][end - 1] == 0) {
            isHui[start][end] = 0;
            return 0;
        }

        if (isHui[start + 1][end - 1] == 1)
            if (s.charAt(start) == s.charAt(end)) {
                isHui[start][end] = 1;
                maxString = maxString.length()>end - start + 1?maxString:s.substring(start,end+1);
                return 1;
            } else {
                isHui[start][end] = 0;
                return 0;
            }

        if (isHui[start + 1][end - 1] == -1) {
            if (s.charAt(start) == s.charAt(end)) {
                int res = longestPalindrome(s, start + 1, end - 1);
                isHui[start][end] = res;

                if (res == 1) {
                    maxString = maxString.length()>end - start + 1?maxString:s.substring(start,end+1);
                }
                return res;
            } else {
                isHui[start][end] = 0;
                return 0;
            }
        }
        throw new RuntimeException("不会到这里");
    }

    public String longestPalindrome(String s) {
        isHui = new int[s.length()][s.length()];
        for (int i = 0; i < isHui.length; i++)
            Arrays.fill(isHui[i], -1);
        longestPalindrome(s,0,s.length()-1);
        return maxString;
    }

    public static void main(String[] args) {
        String s = "abb";
        L5最长回文串_错误 l5 = new L5最长回文串_错误();
        String s1 = l5.longestPalindrome(s);
        System.out.println(s1);
    }
}