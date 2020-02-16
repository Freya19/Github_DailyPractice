package gepeng18.sword2offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//class ListNode {
//    int val;
//    ListNode next = null;
//    ListNode(int val) {
//        this.val = val;
//    }
//}

public class 从尾到头打印链表P58 {
    public static void main(String[] args) {
        final ListNode listNode1 = new ListNode(1);
        final ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        final ArrayList<Integer> integers = printListFromTailToHead(listNode1);
        integers.forEach(System.out::println);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(!stack.empty()){
            final Integer num = stack.pop();
            arrayList.add(num);
        }
        return arrayList;
    }
}
