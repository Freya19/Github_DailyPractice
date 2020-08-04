package gepeng18.专题.括号题;

import com.sun.org.apache.xml.internal.security.keys.ContentHandlerAlreadyRegisteredException;

import javax.xml.soap.SOAPElementFactory;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class L20有效的括号 {
    LinkedList<Character> stack = new LinkedList();
    public boolean isValid(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{' )
                stack.addLast(s.charAt(i));
            else{
                if(stack.size() == 0)
                    return false;
                Character top = stack.pollLast();
                if(s.charAt(i) == ')' && top == '(')
                    continue;
                if(s.charAt(i) == ']' && top == '[')
                    continue;
                if(s.charAt(i) == '}' && top == '{')
                    continue;
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new L20有效的括号().isValid("()");
    }
}
