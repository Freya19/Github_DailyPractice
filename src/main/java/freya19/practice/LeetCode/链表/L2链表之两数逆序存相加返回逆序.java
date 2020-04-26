package freya19.practice.LeetCode.链表;
/*
给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)。输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

import freya19.practice.LeetCode.ListNode;

public class L2链表之两数逆序存相加返回逆序 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0); //返回的和的链表的虚拟头节点
            ListNode cur = pre; //返回的和的链表的当前节点（此处是指向虚拟头节点的）
            int carry = 0;// 进位与否的标志数

            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val; //当有一个数字的长度比另一个短时，补0以达到相同长度
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;

                carry = sum / 10;//进位数
                sum = sum % 10;//实际要存入的值
                cur.next = new ListNode(sum); //每得到一个位数的和，就要在当前节点的下一位新建一个节点存数据

                cur = cur.next; //同cur节点往后移动一位，进行下一位的计算
                if (l1 != null) l1 = l1.next; //同时传入的两个数据对应的链表的节点也往后移动一位
                if (l2 != null) l2 = l2.next;
            }
            if (carry == 1) {//carry和1都是基本数据类型，所以用==
                cur.next = new ListNode(carry); //最后，如果最后得到的进位数是1，那么就要后面再创建一个节点存放这个1
            }
            return pre.next;
        }
    }
