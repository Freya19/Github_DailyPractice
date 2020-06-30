package gepeng18.专题.链表;

import gepeng18.leetcode.ListNode;

/**
 * 剑指offer:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 我们可以这样分析:
 *
 *     假设我们有两个链表 A,B；
 *     A的头节点A1的值与B的头结点B1的值比较，假设A1小，则A1为头节点；
 *     A2再和B1比较，假设B1小,则，A1指向B1；
 *     A2再和B2比较 就这样循环往复就行了，应该还算好理解。
 *
 * 考虑通过递归的方式实现！
 */
public class 合并两个排序的链表 {
    //将list1和list2进行归并后，返回结果的头指针
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return dummyNode.next;
    }
}
