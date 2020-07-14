package freya19.practice.算法题和数据结构.链表;

import freya19.practice.不好归类的题目.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1: 输入: 1->2；          输出: false
 * 示例 2: 输入: 1->2->2->1 ；     输出: true
 * 进阶：用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * O(1)空间复杂度 —— 对半分开，后半段逆转。然后比较两个链表是否相等
 */

public class L234回文链表 {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //偶数个节点
        if (fast != null) {
            slow = slow.next;
        }
        cut(head, slow);
        return isEquals(head, reverse(slow));

    }

    private boolean isEquals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    /**
     * 反转链表
     */
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    /**
     * 将链表分成两段
     */
    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }
}
