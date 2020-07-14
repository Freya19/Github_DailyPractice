package freya19.practice.算法题和数据结构.回溯;

import java.util.ArrayList;
import java.util.List;

/**
看不懂
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class L17PhoneNumber {
    private String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    // 下面两个函数操作的是同一个res
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.equals("")) return res;

        // 递归调用的这个函数 本身没有返回值（void）
        findCombination(digits, 0, "");
        // 但是其中对res进行了操作

        return res;
    }

    // 传入的是数字字符串，找它的第index索引对应的数字，
    // 然后再去letterMap中寻找对应的字母，s中存的是index-1个字符串
    public void findCombination(String digits, int index, String s) {

        //递归终止条件（传入的数字字符串查完了），将得到的对应的字母字符串添加到结果集
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        Character n = digits.charAt(index);
        //数字在0-9之间，且不等于1
        assert (n.compareTo('0') >= 0 && n.compareTo('9') <= 0 && n.compareTo('1') != 0);       //                2
                                                                                                //         a/    b|    c\
        // 假设数字是2，得到的字符串是“abc"                                                                 3      3       3
        String ls = letterMap[n - '0'];                                                         //       / | \  / | \   / | \
        for (int i = 0; i < ls.length(); i++) {                                                 //      d  e  f d e  f  d e  f
            // 假设是第一个字母 a，那么此时就要找数字字符串的下一位（index+1）数字(假设是3），
            // 找它对应的字母串（递归）   “def"，此时这里的s已经是 '+'a 了
            findCombination(digits, index + 1, s + ls.charAt(i));
        }
    }
}
