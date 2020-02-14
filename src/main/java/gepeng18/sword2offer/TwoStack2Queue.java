package gepeng18.sword2offer;

import java.util.Stack;

public class TwoStack2Queue<E> {
    Stack<E> stack1 ;
    Stack<E> stack2;

    public TwoStack2Queue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(E e){
        //直接push到栈1中
        stack1.push(e);
    }
    public E pull(){
        if(stack1.isEmpty()&&stack2.empty())
            throw new RuntimeException("出异常啦！队列为空");
        E res = null;
        //如果栈2有数，则从栈2中删除，没有则将所有数移动到栈2中，再删栈2
        if(!stack2.isEmpty()) {
            res = stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            res = stack2.pop();
        }
        return res;

    }

    public static void main(String[] args) {
        final TwoStack2Queue<Integer> queue = new TwoStack2Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        final Integer res1 = queue.pull();
        final Integer res2 = queue.pull();
        final Integer res3 = queue.pull();
        System.out.println(res1+" "+res2+" "+res3);
    }
}
