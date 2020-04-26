package gepeng18.专题.链表;

import gepeng18.leetcode.ListNode;

/**
 * 题目描述
 * 剑指offer: 输入一个链表，输出该链表中倒数第k个结点。
 * 问题分析
 * 链表中倒数第k个节点也就是正数第(L-K+1)个节点，知道了只一点，这一题基本就没问题！
 * 首先两个节点/指针，一个节点 endNode 先开始跑，指针 endNode 跑到 k-1 个节点后，
 * 另一个节点 startNode 开始跑，当 endNode 跑到最后时，startNode 所指的节点就是倒数第k个节点也就是正数第(L-K+1)个节点。
 */
public class 链表中倒数第k个节点 {

    public ListNode FindKthToTail(ListNode head, int k) {
        // 如果链表为空或者k小于等于0
        if (head == null || k <= 0) {
            return null;
        }
        // 声明两个指向头结点的节点
        ListNode endNode = head, startNode = head;
        // 记录节点的个数
        int count = 0;
        // p指针先跑，并且记录节点数，当endNode节点跑了k-1个节点后，startNode节点开始跑，
        // 当endNode节点跑到最后时，startNode节点所指的节点就是倒数第k个节点

        int endNodeSteps = k;
        while(endNodeSteps>0){
            endNode = endNode.next;
            endNodeSteps--;
            count++;
        }

        while (endNode != null) {
            endNode = endNode.next;
            startNode = startNode.next;
            count++;
        }
        // 如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < k)
            return null;
        return startNode;

    }

    public static void main(String[] args) {
        ListNode listHead = ListUtils.createListHead(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = new 链表中倒数第k个节点().FindKthToTail(listHead, 3);
        System.out.println(listNode.val);
    }
}
