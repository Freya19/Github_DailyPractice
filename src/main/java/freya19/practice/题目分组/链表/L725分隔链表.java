package freya19.practice.题目分组.链表;

import freya19.practice.题目分组.ListNode;

/**
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 */

public class L725分隔链表 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        //首先，当然是遍历一遍链表得到它的长度
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N++;
            cur = cur.next;
        }

        int mod = N % k;
        int len = N / k;
        //上面遍历的时候，cur已经走到了链表的尾了
        cur = root;
        ListNode[] ret = new ListNode[k];

        for (int i = 0; cur != null && i < k; i++) {
            //这个节点数组存放的是每个子链表的头节点
            ret[i] = cur;

            //这是当前子链表的长度
            int curLen = len + (mod > 0 ? 1 : 0);
            mod--;

            for (int j = 0; j < curLen - 1; j++) {
                //链表节点一直往后移动，直到指向该部分的最后一个节点
                cur = cur.next;
            }
            //创建一个新的next节点，指向的是下一子链表的首节点
            ListNode next = cur.next;
            //同时当前部分的尾节点做处理：指向null
            cur.next = null;
            //最后将cur节点移动至下一个子链表的头节点
            cur = next;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        ListNode head = new ListNode(arr);

        ListNode[] listNodes = new L725分隔链表().splitListToParts(head, k);

        for (ListNode listnode : listNodes) {
            System.out.println(listnode);
        }

    }
}
