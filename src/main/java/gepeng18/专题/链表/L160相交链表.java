package gepeng18.专题.链表;

import gepeng18.leetcode.old.ListNode;

/**
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:    b1 → b2 → b3
 * 返回 c1
 *
 * 注意
 *  如果两个链表没有交点，返回 null.
 *  在返回结果后，两个链表仍须保持原有的结构。
 *  可假定整个链表结构中没有循环。
 *  程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */

public class L160相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA, l2=headB;
        while (l1!=l2){
            //这里是 相当于 两个链表相加，为的是同时遍历到交点
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        //当l1==l2退出循环的时候，也就是找到交点的时候
        //值得注意的是，即使不存在交点，最终返回null的情况也包含了，因为没交点，l1==l2==null啦
        return l1;
    }
}
