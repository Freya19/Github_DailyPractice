package gepeng18.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

class SolutionL24 {
    public void swapTwoNodeAfterThisNode(ListNode node){
        ListNode tmp = node.next;
        node.next = tmp.next;
        tmp.next = tmp.next.next;
        node.next.next = tmp;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummpyNode = new ListNode(0);
        dummpyNode.next = head;
        ListNode current = dummpyNode;
        while(current.next!=null && current.next.next!=null){
            swapTwoNodeAfterThisNode(current);
            current = current.next.next;

        }
        return dummpyNode.next;
    }
}
class everyTwoNodeSwapL2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = null;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        ListNode listNode = new SolutionL24().swapPairs(listNode1);
        System.out.println();
    }


}
