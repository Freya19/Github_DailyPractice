package gepeng18.sword2offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;
     ListNode(int val) {
        this.val = val;
    }
}

public class P58 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.empty()) {
            Integer pop = stack.pop();
            list.add(pop);
        }
        return list;


    }
}



