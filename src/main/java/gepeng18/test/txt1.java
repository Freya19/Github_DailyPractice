package gepeng18.test;


import java.util.Stack;

public class txt1 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pull() {
        if(stack1.isEmpty()&&stack2.isEmpty()) throw new RuntimeException("队列为空了。。。");
        int res = -1;
        if(!stack2.isEmpty()){ // stack2中有数，直接javascript:void(0);从stack中pop
            res = stack2.pop();
        }else {
            while ((!stack1.isEmpty())) {
                stack2.push(stack1.pop());
            }
            res = stack2.pop();
        }
        return res;
    }
}