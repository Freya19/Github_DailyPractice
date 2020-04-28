package freya19.practice.LeetCode.队列;

import java.util.Stack;
/**
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
class CQueue {
//    Stack<Integer> inputStack, outputStack;
//
//    public CQueue() {
//        inputStack = new Stack<>();
//        outputStack = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        inputStack.push(value);
//    }
//
//    public int deleteHead() {
//        if (inputStack.isEmpty() && outputStack.isEmpty())
//            throw new RuntimeException("Queue is empty!");
//        if (outputStack.isEmpty()) {
//            while (!inputStack.isEmpty())
//                outputStack.push(inputStack.pop());
//        }
//        return outputStack.pop();
//    }

    /**
     * 官方答案
     */

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }


    public static void main(String[] args) {
        int i=0;
        if("md".equals("1234".substring(1,3))) {
            System.out.println();
        }
    }
}
