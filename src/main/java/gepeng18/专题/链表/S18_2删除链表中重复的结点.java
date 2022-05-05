package gepeng18.专题.链表;

import gepeng18.leetcode.old.ListNode;

public class S18_2删除链表中重复的结点 {
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
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listHead = ListUtils.createListTail(new int[]{1,2,3,3,4,4,5});
        ListNode listNode = new S18_2删除链表中重复的结点().deleteDuplication(listHead);
        ListUtils.printList(listNode);
    }
}
