package gepeng18.专题.队列;

import java.util.Stack;

/**
 * 既然题目给了我们两个栈，我们可以这样考虑当push的时候将元素push进inputStack，
 * pop的时候我们先把inputStack的元素pop到outputStack，然后再对outputStack执行pop操作，这样就可以保证是先进先出的。
 * （负[pop]负[pop]得正[先进先出]）
 */
public class 用两个栈实现队列 {

    Stack<Integer> inputStack = new Stack<Integer>();
    Stack<Integer> outputStack = new Stack<Integer>();

    //当执行push操作时，将元素添加到inputStack
    public void push(int node) {
        inputStack.push(node);
    }

    public int pop() {
        //如果两个队列都为空则抛出异常,说明用户没有push进任何元素
        if (inputStack.empty() && outputStack.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        //如果outputStack不为空直接对outputStack执行pop操作，
        if (outputStack.empty()) {
            while (!inputStack.empty()) {
                //将inputStack的元素按后进先出push进outputStack里面
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }
}
