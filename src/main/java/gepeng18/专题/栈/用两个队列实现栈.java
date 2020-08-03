package gepeng18.专题.栈;

import gepeng18.sword2offer.TwoQueue2Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一直保持一个队列为空，push值总往有值的队列push
 * pop时 先将所有元素pop到另外一个队列中，再弹出来
 * @param <E>
 */
public class 用两个队列实现栈<E> {
    Queue<E> queue1;
    Queue<E> queue2;
    byte valid;

    public 用两个队列实现栈() {
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
        //谁有值则将除最后一个外，其他的值都送到另一个队列中
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
        用两个队列实现栈<Integer> stack = new 用两个队列实现栈<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        final Integer res1 = stack.pop();
        final Integer res2 = stack.pop();
        final Integer res3 = stack.pop();
        System.out.println(res1 + " " + res2 + " " + res3);
    }
}
