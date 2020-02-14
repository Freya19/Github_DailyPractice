package gepeng18.sword2offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoQueue2Stack<E> {
    Queue<E> queue1;
    Queue<E> queue2;
    byte valid;

    public TwoQueue2Stack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
        this.valid = 1;
    }

    public void push(E x) {
        //判断谁有值，谁有值则放到谁那去
        if (this.valid == 1) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    public E pop() {
        //谁有值则将除最后一个外，其他的值都送到另一个栈中
        if (valid == 1) {
            if (queue1.isEmpty())
                throw new RuntimeException("栈已空");
            //数都在stack1那里
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            valid = 2;
            return queue1.poll();
        } else {
            if (queue2.isEmpty())
                throw new RuntimeException("栈已空");
            //数都在stack2那里
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            valid = 1;
            return queue2.poll();
        }
    }

    public static void main(String[] args) {
        TwoQueue2Stack<Integer> stack = new TwoQueue2Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        final Integer res1 = stack.pop();
        final Integer res2 = stack.pop();
        final Integer res3 = stack.pop();
        System.out.println(res1 + " " + res2 + " " + res3);
    }

}
