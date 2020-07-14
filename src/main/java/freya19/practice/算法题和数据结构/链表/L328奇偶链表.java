package freya19.practice.算法题和数据结构.链表;

import freya19.practice.不好归类的题目.ListNode;

/*class ListNode328 {
    int val;
    ListNode328 next;

    ListNode328() {
    }

    ListNode328(int val) {
        this.val = val;
    }

    ListNode328(int val, ListNode328 next) {
        this.val = val;
        this.next = next;
    }
}*/

/**
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class L328奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            //odd指向下一个奇数（even的下一位节点）
            odd.next = odd.next.next;
            //odd移动到下一个奇数节点（这里的odd.next也就等于上式的odd.next.next），
            //也就是现在的odd指向了odd指向的节点
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        //奇偶指向全部改变之后，将最后一个奇数位的next指向偶数位的首位（evenHead）
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        ListNode head = new L328奇偶链表().oddEvenList(listNode);
        System.out.println(head);
    }
}
