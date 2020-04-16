package gepeng18.专题.回溯;

import java.util.List;
import java.util.ArrayList;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
class L17电话号码的字母组合 {

    private String letterMap[] = {
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
    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if (digits.equals(""))
            return res;
        findCombination(digits, 0, "");
        return res;
    }

    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
    private void findCombination(String digits, int index, String s) {
        // 这个是递归终止条件（当这个findCombination再次被调用，走到这一步的时候，
        // 满足if里面的条件，就保存s到结果集里，否则就继续向下执行递归）
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        Character c = digits.charAt(index); //某个数字，比如说是2
        //下面断言表示：0 <= c <=9 且 c !=1
        assert c.compareTo('0') >= 0 &&
                c.compareTo('9') <= 0 &&
                c.compareTo('1') != 0;
        String letters = letterMap[c - '0']; // - ASCII码  letterMap中对应的是"abc"
        for (int i = 0; i < letters.length(); i++) { // i=0时是a， s=s+a，这时候要去看index+1对应的数字，同样操作。进行组合。
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }
}
