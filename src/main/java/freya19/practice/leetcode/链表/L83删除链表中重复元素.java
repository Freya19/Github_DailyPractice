package freya19.practice.leetcode.链表;
/*
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
输入: 1->1->2。输出: 1->2

示例 2:
输入: 1->1->2->3->3。输出: 1->2->3
 */

import freya19.practice.leetcode.ListNode;

public class L83删除链表中重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            if(cur.next.val==cur.val){
                ListNode delNode = cur.next;
                cur.next=delNode.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
    }
}

//(cur!=null&&cur.next!=null)这里的判断一定要注意cur.next不为空