package freya19.practice.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class p58PrintLinkedListFromTail2Head {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //将链表的数据存到栈中
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }

        // 要打印出来，而且最终返回的是Arraylist
        // 将stack中的数据pop出来，全部存到ArrayList中
        ArrayList<Integer> al = new ArrayList<>();
        while(!stack.isEmpty()){
            al.add(stack.pop());
        }
        for(Integer i:al){
            System.out.print(i+"——>");
        }
        System.out.print("null");
        System.out.println();
        return al;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;

        p58PrintLinkedListFromTail2Head ltail=new p58PrintLinkedListFromTail2Head();
        ltail.printListFromTailToHead(l1);
    }

}
