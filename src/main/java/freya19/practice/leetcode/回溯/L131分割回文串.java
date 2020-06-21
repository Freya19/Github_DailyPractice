package freya19.practice.leetcode.回溯;
/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。

示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 */


import java.util.ArrayList;
import java.util.List;

public class L131分割回文串 {
    //存放最终结果并返回
    List<List<String>> res = new ArrayList<>();

    /**
     * 是否为回文的判断函数
     * @param str
     * @return
     */
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public void findPartition(String s, List<String> state) {
        if (s.length() == 0) {
            res.add(state);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                ArrayList<String> tempList = new ArrayList<>(state);
                tempList.add(s.substring(0, i + 1));
                findPartition(s.substring(i + 1), tempList);
            }
        }
    }

    //LeetCode中函数的入口
    public List<List<String>> partition(String s) {
        ArrayList<String> state = new ArrayList<>();
        findPartition(s, state);
        return res;
    }






    public static void main(String[] args) {
        L131分割回文串 l131 = new L131分割回文串();
        List<List<String>> res = l131.partition("aab");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
