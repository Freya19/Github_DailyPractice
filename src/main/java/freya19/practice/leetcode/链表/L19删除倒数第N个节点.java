package freya19.practice.leetcode.链表;


import freya19.practice.leetcode.ListNode;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？
 */
public class L19删除倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        //获取原链表的长度
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next) {
            length++;
        }

        int k = length - n;
        assert k >= 0;
        //通过依次遍历，找到要删除节点的前一个节点
        ListNode cur = dummyHead;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        L19删除倒数第N个节点 l19 = new L19删除倒数第N个节点();
        ListNode ret = l19.removeNthFromEnd(pre.next, 4);
        System.out.println(ret.toString());

    }
}
