package freya19.practice.面试;

import freya19.practice.不好归类的题目.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 合并K个排序链表 {
    public ListNode merge(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 创建一个小顶堆，每个链表的头节点先放进去，
        // 负数代表左值小于右值; 正数代表左值大于右值; 0代表左值等于右值
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            cur.next = min;
            cur = cur.next;
            if (min.next != null) {
                minHeap.add(min.next);
            }
        }
        return dummyHead.next;
    }
}
