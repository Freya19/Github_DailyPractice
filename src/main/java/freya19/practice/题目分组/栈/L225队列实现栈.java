package freya19.practice.题目分组.栈;

import java.util.LinkedList;
import java.util.Queue;

/**在将一个元素 x 插入队列时，为了维护原来的后进先出顺序，需要让 x 插入队列首部。
 * 而队列的默认插入顺序是队列尾部，
 * 因此在将 x 插入队列尾部之后，需要让除了 x 之外的所有元素出队列，再入队列。*/

public class L225队列实现栈 {
    private Queue<Integer> queue;

    public L225队列实现栈(){
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    /**将 x 插入队列尾部之后，需要让除了 x 之外的所有元素出队列，再入队列。以保证栈的后进先出性*/
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size-->1){
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        if(!queue.isEmpty()){
            return queue.peek();
        }else {
            return -1;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
