package gepeng18.专题.字符串;

import java.util.Arrays;

/**
 * Leetcode: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 思路很简单！先利用Arrays.sort(strs)为数组排序，再将数组第一个元素和最后一个元素的字符从前往后对比即可！
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        // 如果检查值不合法及就返回空串
        if (!checkStrs(strs)) {
            return "";
        }

        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);
        int m = strs[0].length();   //这里有疑问，见test1
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        // 实际上，这里用m完全可以
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;
        }
        return res.toString();
    }

    private boolean checkStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            // 遍历strs检查元素值
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }


    // 测试
    public static void main(String[] args) {
        // new 最长公共前缀().test1();
        // String[] strs = { "customer", "car", "cat" };
        // String[] strs = { "customer", "car", null };//空串
        // String[] strs = {};//空串
        // String[] strs = null;//空串
        // System.out.println(new 最长公共前缀().longestCommonPrefix(strs));// c


    }

    public void test1(){
        //疑惑1：int num = Math.min(m, n); 也就是说长度最短的串一定在开始或者结尾，既然按照字符串排序，那么可能c在z的前面，
        //za在最后面，c在倒数第2啊
        String [] strs = new String[]{"ab","12","c","za"};
        Arrays.sort(strs);
        for (String str : strs) {
            System.out.println(str); //  12 zb c za
        }
        //这样判断strs[0].charAt(i) == strs[len - 1].charAt(i) 可能会越界啊

        //解答：判断第一位是公共前缀吗？这时所有的字符串第一位要么是空，空一定在第一个，要么就有值，继续第二位，既然能判断到第二位,第一位没有return
        //那表明第一位就是公共前缀，那么第二位要么是空，空一定在第一个，，要么就有值
        //综上，我的测试用例，第一位不是公共子串，所以就不会判断到第二位了
        /**
         *         所以我认为
         *         int m = strs[0].length();
         *         int n = strs[len - 1].length();
         *         int num = Math.min(m, n);
         *         for (int i = 0; i < num; i++) {
         *
         *         改成
         *
         *         int m = strs[0].length();
         *         for (int i = 0; i < m; i++){
         *
         *         完全可以，因为第一个字符串才是公共中有可能最短的（空和非空比较）
         *
         *         经证明，成立。
         *
         */


    }

}

