package gepeng18.test;

import gepeng18.leetcode.old.ListNode;

public class 删除链表结点 {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
            return head;
        } else {
           ListNode dummyNode = new ListNode(-1);
           dummyNode.next = head;
           ListNode cur = dummyNode;
           while (cur.next!=null){
               if(cur.next == tobeDelete){
                   cur.next = cur.next.next;
                   break;
               }else {
                   cur = cur.next;
               }
           }
           return dummyNode.next;
        }

    }
}
