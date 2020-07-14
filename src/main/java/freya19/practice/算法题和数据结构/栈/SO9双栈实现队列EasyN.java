package freya19.practice.算法题和数据结构.栈;

import java.util.LinkedList;

public class SO9双栈实现队列EasyN {
//public class CQueue {

    LinkedList<Integer> stackIn;
    LinkedList<Integer> helper;

        public SO9双栈实现队列EasyN() {
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
