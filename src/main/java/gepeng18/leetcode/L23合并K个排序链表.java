package gepeng18.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */

class SolutionL23 {
    class ListNodeCompare implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val-b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length == 0){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        ListNodeCompare listNodeCompare = new ListNodeCompare();
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(listNodeCompare);

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                priorityQueue.add(lists[i]);
        }
        while(!priorityQueue.isEmpty()){
            ListNode min = priorityQueue.poll();
            current.next = min;
            current = current.next;
            if(min.next!=null){
                priorityQueue.add(min.next);
            }
        }
        return dummyNode.next;
    }
}
class 合并K个排序链表L23 {
}
