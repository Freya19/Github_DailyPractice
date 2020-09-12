package gepeng18.专题.括号题;

import com.sun.jndi.cosnaming.CNCtx;

import java.util.ResourceBundle;
import java.util.Stack;

public class 括号组 {
    public static int func(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean leftBefore = false;
        boolean rightBefore = false;
        int leftCnt = 0;
        int rightCnt = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' && leftBefore) {
                leftCnt++;
            } else if (s.charAt(i) == '{' && !leftBefore) {
                leftBefore = true;
                leftCnt++;
            } else if (s.charAt(i) == '}' && rightBefore) {
                rightCnt++;
            } else if (s.charAt(i) == '}' && !rightBefore) {
                rightBefore = true;
                rightCnt++;
            } else {
                leftBefore = false;
                rightBefore = false;
                leftCnt = 0;
                rightCnt = 0;
            }

            if (s.charAt(i) == '{'){
                if (rightCnt != 0) {
                    if (stack.pop() == rightCnt)
                        res++;
                    else
                        return 0;
                }
                rightBefore = false;
                rightCnt =0;
            }else if (s.charAt(i) == '}'){
                if (leftCnt != 0) {
                    stack.push(leftCnt);
                }
                leftBefore = false;
                leftCnt =0;
            }else{
                if (rightCnt != 0) {
                    if (stack.pop() == rightCnt)
                        res++;
                    else
                        return 0;
                }
                if (leftCnt != 0) {
                    stack.push(leftCnt);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int res = func("aaa{{{{{bbbccc}}}}}ddd");
        System.out.println(res);
    }
}
