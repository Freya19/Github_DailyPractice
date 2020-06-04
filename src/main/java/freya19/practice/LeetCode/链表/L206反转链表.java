package freya19.practice.LeetCode.链表;/*
反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */

import freya19.practice.LeetCode.ListNode;

public class L206反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            //cur原本指向的下一个节点，用next保存
            ListNode next = cur.next;
            //然后将cur指向前一个节点
            cur.next = pre;
            // 前一个节点现在往后移动一位，在cur的位置
            pre = cur;
            // cur也同样往后移动一位
            cur = next;
        }
        return pre;
    }
}
