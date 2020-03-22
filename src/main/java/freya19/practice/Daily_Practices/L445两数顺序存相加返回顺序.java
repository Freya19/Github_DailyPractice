package freya19.practice.Daily_Practices;

import java.util.Stack;

/*
给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例:

输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)。输出: 7 -> 8 -> 0 -> 7

 */
public class L445两数顺序存相加返回顺序 {
    //要用到栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> res = new Stack<>();
        //将两个链表中存的加数压入栈中
        for (ListNode current = l1; current != null; current = current.next) {
            s1.push(current.val);
        }
        for (ListNode current = l2; current != null; current = current.next) {
            s2.push(current.val);
        }

        int carry = 0;
        int x=0;
        int y=0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                x = s1.peek();
                s1.pop();
            } else {
                x = 0;
            }
            if (!s2.isEmpty()) {
                y = s2.peek();
                s2.pop();
            } else {
                y = 0;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            res.push(sum);

        }
        if (carry == 1){
            res.push(1);
        }

        //将res中元素返回到链表中
        //注意这里虚拟头节点不能移动
        ListNode pre = new ListNode(0);//虚拟头节点
        ListNode current = pre;
        while (!res.isEmpty()) {
            current.next=new ListNode(res.peek());
            res.pop();
            current = current.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {

       int[] arr1 = {7,2,4,3};
       int[] arr2 = {5,6,4};
       ListNode pre1 = new ListNode(0);//虚拟头节点
       ListNode current = pre1;
       for(int arr:arr1){
           current.next=new ListNode(arr);
           current=current.next;
       }

       //注意这里虚拟头节点不能移动
        ListNode pre2 = new ListNode(0);//虚拟头节点
        ListNode current2 = pre2;
        for(int arr:arr2){
            current2.next=new ListNode(arr);
            current2=current2.next;
        }

        new L445两数顺序存相加返回顺序().addTwoNumbers(pre1.next,pre2.next);

    }
}
