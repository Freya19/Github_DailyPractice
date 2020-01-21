/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:输入: "()"；输出: true
示例 2:输入: "()[]{}"；输出: true
示例 3:输入: "(]"；输出: false
示例 4:输入: "([)]"；输出: false
示例 5:输入: "{[]}"；输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package freya19.practice.Daily_Practices;

import java.util.Stack;

public class validBracketsSolutionL20 {
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                sk.push(s.charAt(i));
            }else if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                if(sk.empty()) return false;
                char cur = sk.pop();

                if(cur=='('&&s.charAt(i)!=')') return false;
                if(cur=='['&&s.charAt(i)!=']') return false;
                if(cur=='{'&&s.charAt(i)!='}') return false;
            }
        }
        if(sk.isEmpty()) return true;
        return false;
    }
}

class tesL20 {
    public static void main(String[] args) {
    String s1 = "([{})]";
    String s2 = "([{}])";
    validBracketsSolutionL20 vb = new validBracketsSolutionL20();

    System.out.println(vb.isValid(s1));
    System.out.println( vb.isValid(s2));

    }
}
