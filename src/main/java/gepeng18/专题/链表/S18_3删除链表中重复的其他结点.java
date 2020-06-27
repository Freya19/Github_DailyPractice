package gepeng18.专题.链表;

import gepeng18.leetcode.ListNode;

public class S18_3删除链表中重复的其他结点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null)
            return null;
        for(ListNode first = pHead;first.next!=null;first = first.next){
            for(ListNode second = first.next;second.next!=null;){
                if(first.val == second.val){
                    deleteNextNode(first);
                    second = first.next;
                }else {
                    break;
                }
            }
        }
        return pHead;
    }

    private void deleteNextNode(ListNode first) {
        ListNode second = first.next;

        first.next = second.next;
        second = null;
    }

    public static void main(String[] args) {
        ListNode listHead = ListUtils.createListTail(new int[]{1, 1, 2, 3, 4, 4, 5});
        ListNode listNode = new S18_3删除链表中重复的其他结点().deleteDuplication(listHead);
        ListUtils.printList(listNode);
    }
}
