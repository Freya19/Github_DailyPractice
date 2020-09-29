/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例： 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4

来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package freya19.practice.算法题和数据结构.链表;


import freya19.practice.不好归类的题目.ListNode;

// 合并两个有序链表的方法类
public class L21MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while(l1!=null&&l2!=null){
            //视频的方法
//            boolean flag = (l1.val<l2.val);
//            curr.next = flag?l1:l2;
//            curr = curr.next;
//            l1 = flag?l1.next:l1; //如果l1<l2，返回l1指向l1的下一个节点，反之就还是l1；然后走下面一行代码
//            l2 = flag?l2:l2.next;

            //我的基本方法
            if(l1.val < l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }else{
                curr.next=l2;
                curr = curr.next;
                l2=l2.next;
            }
        }
//        视频的方法
//        curr.next=(l1==null)?l2:l1; //这里想判断的是，如果一个链表指向了最后的null，curr.next就要指向另一个链表的节点

        //我的方法
        if(l1==null) curr.next=l2;
        if(l2==null) curr.next=l1;

        //最后返回第一个节点
        return dummyHead.next;
    }
}


class testL21{
    public static void main(String[] args) {
        //创建测试链表并打印输出
        int[] nums1 = {1,2,6,8};
        int[] nums2 = {2,4,5};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        //利用写好的显示方法，显示创建的两个测试链表的信息
        System.out.println(head1.toString());
        System.out.println(head2.toString());

        //合并两个测试链表
        L21MergeTwoSortedList m = new L21MergeTwoSortedList();
        ListNode m2 = m.mergeTwoLists(head1,head2);
        System.out.println(m2.toString());

    }

}
