package gepeng18.专题.链表;

/**
 *     eetcode:给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 该题在 leetcode 上有详细解答，具体可参考 Leetcode.
 * 问题分析
 *
 * 我们注意到这个问题可以容易地简化成另一个问题：删除从列表开头数起的第 (L - n + 1)个结点，
 * 其中 L是列表的长度。只要我们找到列表的长度 L，这个问题就很容易解决。
 */

import gepeng18.leetcode.old.ListNode;


public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑结点，哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部
        ListNode dummy = new ListNode(0);
        // 哑结点指向头结点
        dummy.next = head;

        int length = n+1;
        ListNode quick = dummy;
        while (length>0) {
            quick = quick.next;
            length--;
        }

        ListNode slow = dummy;

        while (quick!=null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listHead = ListUtils.createListTail(new int[]{1, 2, 3, 4});
        ListNode listNode = new 删除链表的倒数第N个节点().removeNthFromEnd(listHead, 3);
        ListUtils.printList(listNode);
    }
}
