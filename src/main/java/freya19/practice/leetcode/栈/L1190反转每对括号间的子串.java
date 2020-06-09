package freya19.practice.leetcode.栈;

import java.util.Stack;

/***
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 */
public class L1190反转每对括号间的子串 {
    public String reverseParentheses(String s) {
        //栈存储反转后的字符串
        Stack<String> stack = new Stack<>();
        //初始化，避免空栈异常
        stack.push("");

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(')) {
                stack.push("");
            } else if (c.equals(')')) {
                //右括号就反转匹配的括号间的字符串
                String reverseStr = stack.pop();
                //用StringBuilder来接收
                StringBuilder sb = new StringBuilder();
                for (int j = reverseStr.length() - 1; j >= 0; j--) {
                    Character ch = reverseStr.charAt(j);
                    sb.append(ch);
                }
                //将栈的第二个元素+反转后的字符串 再压入栈
                String str=stack.pop()+sb.toString();
                stack.push(str);
            } else {
                //非括号，就将字符+当前栈顶元素加起来 压入栈
                String popStr = stack.pop();
                popStr += c;
                stack.push(popStr);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        L1190反转每对括号间的子串 l1190 = new L1190反转每对括号间的子串();
        String s1 = "(u(love)i)";
        String ss = l1190.reverseParentheses(s1);
        System.out.println(ss);
    }
}
