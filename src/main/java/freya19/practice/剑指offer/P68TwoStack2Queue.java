package freya19.practice.剑指offer;
/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
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
//        P68TwoStack2Queue queue = new P68TwoStack2Queue();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        System.out.println(queue.pop());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int c = stack.pop();
        System.out.println(c);
        System.out.println( stack.pop());
    }
}
