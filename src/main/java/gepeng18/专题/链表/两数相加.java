package gepeng18.专题.链表;

import gepeng18.leetcode.ListNode;

/**
 * 题目描述
 *
 *     Leetcode:给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 *     你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 问题分析
 *
 * Leetcode官方详细解答地址：
 *
 * https://leetcode-cn.com/problems/add-two-numbers/solution/
 *
 *     要对头结点进行操作时，考虑创建哑节点dummy，使用dummy->next表示真正的头节点。这样可以避免处理头节点为空的边界问题。
 *
 * 我们使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐 位相加的过程。
 *
 * 图1，对两数相加方法的可视化: 342 + 465 = 807， 每个结点都包含一个数字，并且数字按位逆序存储。
 * Solution
 *
 * 我们首先从最低有效位也就是列表 l1和 l2 的表头开始相加。注意需要考虑到进位的情况！
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        //carry 表示进位数
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            //进位数
            carry = sum / 10;
            //新节点的数值为sum % 10
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
