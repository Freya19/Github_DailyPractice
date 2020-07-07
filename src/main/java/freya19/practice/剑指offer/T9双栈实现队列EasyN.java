package freya19.practice.剑指offer;

import java.util.LinkedList;
import java.util.Stack;

public class T9双栈实现队列EasyN {
//public class CQueue {

    LinkedList<Integer> stackIn;
    LinkedList<Integer> helper;

        public T9双栈实现队列EasyN() {
//    public CQueue() {
        stackIn = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void appendTail(int value) {
        stackIn.addLast(value);
    }

    public int deleteHead() {
        if (!helper.isEmpty()) {
            return helper.removeLast();
        }
        if (stackIn.isEmpty()) {
            return -1;
        }
        while (!stackIn.isEmpty()) {
            helper.addLast(stackIn.removeLast());
        }
        return helper.removeLast();

    }
}
