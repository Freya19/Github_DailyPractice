package freya19.practice.LeetCode.栈;

import java.util.Stack;

/**
 * LeetCode 155
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */

public class MinStack {

    /**用双栈。一个数据栈（存原数据），一个辅助栈（存最小元素）*/
    Stack<Integer> data;
    Stack<Integer> helper;

    /**initialize your data structure here.*/
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    /**data栈中无条件push元素，helper中只有比其栈顶元素小的才新增，
     * 否则取helper原栈顶元素再存一次（保证栈顶元素最小）*/
    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() > x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    /**为保证同步，双栈都弹出元素.(注意：Stack中pop弹出且移除，peek是获取不移除)*/
    public void pop() {
        if (!data.isEmpty() && !helper.isEmpty()) {
            data.pop();
            helper.pop();
        }
    }

    /**获取数据栈的栈顶元素。一定一定要用peek。只取不移除。。。！否则后面getMin可能会出现空栈 */
    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈为空，此操作非法！");
    }

    /**获取辅助栈栈顶元素（最小）*/
    public int getMin() {
        if (!data.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈为空，此操作非法！");
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(2);
        minStack.push(5);

        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
