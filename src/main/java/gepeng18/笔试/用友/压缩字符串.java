package gepeng18.笔试.用友;

import java.util.Stack;

/**
 *  比如“aaabbbcaaa” ,压缩成“a3b3c1a3”;
 * 如果压缩后的长度不是小于等于原字符串长度，就返回原字符串
 */
public class 压缩字符串 {
    public String solve(String s){
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<s.length();i++){
            // 针对每一个数字，判断栈是否是空，是空，则直接压入栈
            // 如果栈不是空，则判断和栈顶元素是否相同，相同则入栈
            //                                     不同则将栈中元素全部弹出，计算数量
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else{
                if(s.charAt(i) == stack.peek())
                    stack.push(s.charAt(i));
                else{
                    int num = 0;
                    char cur = stack.peek();
                    while (!stack.isEmpty()){
                        stack.pop();
                        num++;
                    }
                    res.append(cur).append(num);
                    stack.push(s.charAt(i));
                }
            }
        }

        // 将栈中剩余的数字弹出来
        int num = 0;
        char remain = 0;
        while (!stack.isEmpty()){
            remain = stack.pop();
            num++;
        }
        if(num>0)
            res.append(remain).append(num);

        return res.toString();
    }

    public static void main(String[] args) {
        String input = "aaabbbcaaa";
        String res = new 压缩字符串().solve(input);
        if (res.length()<=input.length())
            System.out.println(res);
        else
            System.out.println(input);
    }
}
