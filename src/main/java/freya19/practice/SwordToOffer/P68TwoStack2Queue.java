package freya19.practice.SwordToOffer;

import java.util.Stack;

public class P68TwoStack2Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if(stack1.isEmpty()&&stack2.isEmpty()) throw new RuntimeException("队列为空了。。。");
        int res = -1;
        if(!stack2.isEmpty()){ // stack2中有数，直接从stack中pop
            res = stack2.pop();
        }else {
            while ((!stack1.isEmpty())) {
                stack2.push(stack1.pop());
            }
            res = stack2.pop();
        }
        return res;
    }

    public static void main(String[] args) {
//        int i = 2;
        P68TwoStack2Queue queue = new P68TwoStack2Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
    }
}
