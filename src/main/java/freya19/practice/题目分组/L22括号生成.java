package freya19.practice.题目分组;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，
 * 使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class L22括号生成 {

    List<String> res = new ArrayList<>();

    /**
     * n对括号的生成
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        back(n, "", 0, 0);
        return res;
    }

    /**
     * @param n     括号对数
     * @param state 中间状态
     * @param lc    左边括号数
     * @param rc    右括号数
     */
    public void back(int n, String state, int lc, int rc) {
        if (lc < rc || lc > n || rc > n) {
            return;
        }

        if (lc == rc && lc == n) {
            res.add(state);
            return;
        }

        back(n, state + "(", lc + 1, rc);
        back(n, state + ")", lc, rc + 1);
    }

    public static void main(String[] args) {
        val list = new L22括号生成().generateParenthesis(3);
        for(String l:list){
            System.out.println(l);
        }
    }

}

/*
最多能添加 n 个左括号，在递归调用的时候，在能传递到最底层的共用字符串中先添加 "(" ，然后 left-1，递归调用就可以。
当左括号个数大于右括号的个数时添加右括号。
 */