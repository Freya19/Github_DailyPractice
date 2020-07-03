package freya19.practice.剑指offer;

import gepeng18.test.java设计.整体设计.List;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 递推阶段： 每次传入 head.next ，以 head == null（即走过链表尾部节点）为递归终止条件，此时直接返回。
 * 回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
 * 最终，将列表 tmp 转化为数组 res ，并返回即可。
 */

public class T6从尾到头打印链表N {

    ArrayList<Integer> tmp = new ArrayList<Integer>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }
}
