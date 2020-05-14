package gepeng18.专题.栈;

import java.util.Stack;

/**
 * 将每个数以及目前的最小值一起存到栈中
 */
public class 包含min函数的栈 {

    int min = Integer.MAX_VALUE;

    class Element {
        int num;
        int min;

        public Element(int num, int min) {
            this.num = num;
            this.min = min;
        }
    }

    Stack<Element> stack = new Stack();

    public void push(int node) {
        min = Integer.min(this.min, node);
        stack.add(new Element(node, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().num;
    }

    public int min() {
        return stack.peek().min;
    }

    public static void main(String[] args) {
        包含min函数的栈 instance = new 包含min函数的栈();
        instance.push(1);
        instance.push(-5);
        instance.push(2);
        instance.push(4);
        System.out.println(instance.top());
        System.out.println(instance.min());
    }
}
