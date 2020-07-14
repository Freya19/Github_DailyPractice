package freya19.practice.算法题和数据结构.链表;
/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

示例 2:
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 */

import freya19.practice.不好归类的题目.ListNode;

public class L61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        // 获取原链表的长度
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next) {
            length++;
        }

        //区分k比链表长还是短的情况
        int newK = k % length;

        // 找原链表的尾
        ListNode originalTail = new ListNode(0);
        ListNode cur = dummyHead;
        for (int i = 0; i < length; i++) {
            cur = cur.next;
        }
        originalTail = cur;

        // 将原链表的尾指向原链表的头，变成一个环形的链表啦
        originalTail.next = head;

        // 找到要旋转的位置，打开这个链表，也就是找到新的head的位置和尾的位置
        int indexHead = length - newK;
        int indexTail = length - newK - 1;

        // 找新链表的头和尾
        ListNode newHead = new ListNode(0);
        ListNode newTail = new ListNode(0);

        // 新头
        ListNode newCur1 = dummyHead;
        for (int i = 0; i <= indexHead; i++) {
            newCur1 = newCur1.next;
        }
        newHead = newCur1;

        // 新尾
        ListNode newCur2 = dummyHead;
        for (int i = 0; i <= indexTail; i++) {
            newCur2 = newCur2.next;
        }
        newTail = newCur2;

        // 把头和尾指向给制定好
        dummyHead.next = newHead;
        newTail.next = null;

        //最终返回这个新的头
        return newHead;
    }
}
