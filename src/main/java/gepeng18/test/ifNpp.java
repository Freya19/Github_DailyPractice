package gepeng18.test;

import gepeng18.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * class Solution {
 * public:
 *     int maxProfit(vector<int>& prices) {
 *         int beg=0;//买入点
 *         int end=0;//卖出点
 *         int pro=0;//利润初始化为0应付价格一直下跌
 *         int record=0;//记录当日卖出的最大利润
 *         for(end=0;end<prices.size();end++)
 *         {
 *              if(prices[beg]>prices[end])//遇到价格更低时直接重置买入价格
 *                 beg=end;
 *             int record=prices[end]-prices[beg];
 *             pro=record>pro?record:pro;
 *         }
 *         return pro;
 *     }
 * };
 */
public class ifNpp {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            //头结点或者尾结点
            if (head == tobeDelete)
                // 只有一个节点
                head = null;
            else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
}
