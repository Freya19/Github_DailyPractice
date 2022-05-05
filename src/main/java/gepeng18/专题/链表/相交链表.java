package gepeng18.专题.链表;

import gepeng18.leetcode.old.ListNode;

import java.util.HashSet;

/**
 * 160. 相交链表
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<Object> set = new HashSet<>();
        ListNode current = headA;
        while(current!=null){
            set.add(current);
            current = current.next;
        }

        current = headB;
        while(current!=null){
            if(set.contains(current))
                return current;
            current = current.next;
        }
        return null;

    }
}
