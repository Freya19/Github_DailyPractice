package freya19.practice.算法题和数据结构.链表;

import freya19.practice.不好归类的题目.ListNode;
import java.util.ArrayList;

/**
 * 递推阶段： 每次传入 head.next ，以 head == null（即走过链表尾部节点）为递归终止条件，此时直接返回。
 * 回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
 * 最终，将列表 tmp 转化为数组 res ，并返回即可。
 */

public class SO6从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {

        if(head == null){
            return new int[]{};
        }

        ListNode tmpHead = head;
        int cnt =0;
        while (tmpHead!=null){
            cnt++;
            tmpHead=tmpHead.next;
        }

        int[] res = new int[cnt];
        for(int i=res.length-1;i>=0;i--){
            if(head!=null){
                res[i]=head.val;
                head=head.next;
            }
        }

        return res;
    }
}
