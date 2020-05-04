package freya19.practice.LeetCode.链表;
/*
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾
连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */

import freya19.practice.LeetCode.ListNode;

import java.util.HashMap;

public class L141环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;

        if (p == null || p.next == null) {
            return false;
        }

        HashMap<ListNode, Integer> map = new HashMap<>();
        //遇到环就死循环了。。。。，所以通过下面的key（出现两次）就return true来跳出循环
        while (p.next != null) {
            ListNode key = p;
            Integer value = map.get(key);
            // p这个节点还没有出现过，就放进去，次数记为1
            if (value == null) {
                map.put(key, 1);
                p = p.next;
            }// p这个节点出现过一次，替换次数为2
            else if (value == 1) {
                map.put(key, value + 1);
                p = p.next;
            }else  //p这个节点出现了两次，就表示找到了环，直接return true
            {
                return true;
            }
        }
        //跳出循环，表示p.next=null了，那就是木有环
        return false;
    }
}
