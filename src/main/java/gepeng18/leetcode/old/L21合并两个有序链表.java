package gepeng18.leetcode.old;

import gepeng18.专题.链表.ListUtils;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class L21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        while(l1!=null && l2!=null){
            ListNode minNode = l1.val < l2.val? l1:l2;
            current.next = minNode;
            current = current.next;
            if(l1.val < l2.val){
                l1 = l1.next;
            } else{
                l2 = l2.next;
            }
        }
        if(l1==null){
            current.next = l2;
        }else{
            current.next = l1;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode list1 = ListUtils.createListHead(new int[]{1, 2, 4});
        ListNode list2 = ListUtils.createListHead(new int[]{1, 3, 4});
        ListNode mergedList = new L21合并两个有序链表().mergeTwoLists(list1, list2);
        ListUtils.printList(mergedList);

    }
}
