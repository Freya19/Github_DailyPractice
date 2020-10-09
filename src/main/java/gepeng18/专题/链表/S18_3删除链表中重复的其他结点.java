package gepeng18.专题.链表;

import gepeng18.leetcode.ListNode;

public class S18_3删除链表中重复的其他结点 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = pHead;
        ListNode pre = dummyNode;
        ListNode cur = dummyNode.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listHead = ListUtils.createListTail(new int[]{1, 1, 2, 3, 4, 4, 5});
        ListNode listNode = new S18_3删除链表中重复的其他结点().deleteDuplication(listHead);
        ListUtils.printList(listNode);
    }
}
