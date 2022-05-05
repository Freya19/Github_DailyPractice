package freya19.practice.面试;

import gepeng18.leetcode.old.ListNode;

public class 合并俩有序链表 {
    public ListNode mergeTwoLinkedList(ListNode head1, ListNode head2) {
        // 需要一个虚拟头节点保存最初的起点
        ListNode dummyHead = new ListNode(-1);

        // 分别指向链表1和链表2的节点
        ListNode cur = dummyHead;

        // 比较当前节点大小，小的节点先放置，然后节点往后移动一位
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }

        // 最后看哪个链表还有剩余的，接上去
        if (head1 == null) {
            cur.next = head2;
        } else {
            cur.next = head1;
        }
        // 最终返回
        return dummyHead.next;
    }
}
