package gepeng18.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 */
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class SolutionL19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpyNode = new ListNode(0);
        dummpyNode.next = head;
        ListNode ending = dummpyNode;
        ListNode before = dummpyNode;
        for (int i = 0; i < n; i++) {
            ending = ending.next;
        }
        while(ending.next!=null){
            ending = ending.next;
            before = before.next;
        }
        before.next = before.next.next;
        return dummpyNode.next;
    }
}

//public class deleteRevNthNodeL19 {
//    public static void main(String[] args) {
//        ListNode head = new ListNode(5);
//        head.next =
//    }
//}
