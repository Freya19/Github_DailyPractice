package gepeng18.专题.栈;

/**
 *856. 括号的分数
 *
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 *     () 得 1 分。
 *     AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 *     (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 *
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 *
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 */
/* ----------------------------------------------------------------------------------------- */

import java.util.Stack;

/**
 * 题解：
 *
 *     构建一个栈
 *     如果遇到(就往栈里面添加
 *     如果遇到)就去寻找最近的左括号抵消，同时计算里面的分数
 *
 * 拿(()(()))示例, 栈结构变化如下
 *
 * [(]                # 遇到 ( 往栈添加
 * [(, (]             # 继续添加
 * [(, 1]             # 遇到 ） 合成一个1
 * [(, 1, (]          # 遇到 ( 往栈添加
 * [(, 1, (, (]       # 继续添加
 * [(, 1, (, 1]       # 遇到 ） 合成一个1
 * [(, 1, 2]          # 遇到 ） ，结构就是（1）， 所以计算的话是 1 * 2
 * [6]                # 遇到 ） ，结构是（1，2）， 所以计算的话是 （1 + 2） * 2
 *
 */
public class L856_括号的分数 {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack();
        for(int i=0;i< S.length();i++){
            if(S.charAt(i) == '(')
                stack.push(String.valueOf(S.charAt(i)));
            else{
                String top;
                if(stack.peek().equals("(")){
                    //栈顶是左括号，则直接push 1进去
                    stack.pop();
                    stack.push("1");
                }else{
                    // 栈顶不是左括号，那肯定是数字了,那就要把所有数字都弹出来后*2
                    int sum = 0;
                    while(!((top = stack.pop()).equals("("))){
                        sum+=Integer.valueOf(top);
                    }
                    stack.push(String.valueOf(sum*2));
                }
            }
        }
        //最后stack中可能存在多个数
        int sum = 0;
        for(String num:stack){
            sum+=Integer.valueOf(num);
        }
        return sum;
    }

}
