package freya19.practice.笔试;

import java.util.Stack;

public class 字符串运算 {
    /**
     * @param input string字符串
     * @return int整型
     */
    public int calculate(String input) {
        // write code here
        Stack<Integer> stack = new Stack<>();

        char lastOp = '+';
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (Character.isDigit(arr[i])) {
                int tmpNum = arr[i] - '0';
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tmpNum = tmpNum * 10 + (arr[i] - '0');
                }
                i--;

                if (lastOp == '+') {
                    stack.push(tmpNum);
                } else if (lastOp == '-') {
                    stack.push(-tmpNum);
                } else {
                    stack.push(res(lastOp, stack.pop(), tmpNum));
                }
            } else {
                lastOp = arr[i];
            }
        }
        int answer = 0;
        for (int num : stack) {
            answer += num;
        }
        return answer;
    }

    private static int res(char op, int a, int b) {
        if (op == '*') {
            return a * b;
        } else if (op == '/') {

            return a / b;
        } else if (op == '+') {
            return a + b;
        } else {
            return a - b;
        }
    }

    public static void main(String[] args) {
        int v = new 字符串运算().calculate("1*2+3");
        System.out.println(v);
    }
}