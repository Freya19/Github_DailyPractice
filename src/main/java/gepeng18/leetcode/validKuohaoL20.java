package gepeng18.leetcode;

import java.util.Stack;

/***
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class SolutionL20 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}') {
                if (stack.empty())
                    return false;


                if ((Character) stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (stack.empty())
                    return false;

                if ((Character) stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (stack.empty())
                    return false;

                if ((Character) stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }else{
            return true;
        }

    }

}
public class validKuohaoL20 {
    public static void main(String[] args) {
        String string = "([{}])]";
        boolean valid = new SolutionL20().isValid(string);
        System.out.println(valid);
    }
}
