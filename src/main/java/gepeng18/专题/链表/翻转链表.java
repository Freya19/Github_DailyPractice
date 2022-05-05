package gepeng18.专题.链表;

import gepeng18.leetcode.old.ListNode;

public class 翻转链表 {


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 这里和下一行冲突了
            ListNode nextTmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTmp;

        }
        return pre;
    }

}
