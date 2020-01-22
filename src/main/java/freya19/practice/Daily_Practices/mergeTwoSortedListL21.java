/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例： 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4

来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package freya19.practice.Daily_Practices;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

//定义一个单向链表
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


    // 根据n个元素的数组arr创建一个链表
    // 使用arr为参数，创建另外一个ListNode的构造函数
    public ListNode (int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode curNode = this;
        for(int i = 1 ; i < arr.length ; i ++){
            curNode.next = new ListNode(arr[i]); //将arr数组里面的元素逐一添加到链表的节点中
            curNode = curNode.next;
        }
    }
}


public class mergeTwoSortedListL21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(l1!=null&&l2!=null){
            boolean flag = l1.val<l2.val;
            curr.next = flag?l1:l2;
            curr = curr.next;
            l1=flag?l1.next:l2;
            l2=flag?l1:l2.next;
        }
        curr.next=(l1==null)?l1:l2;
        return dummyHead.next;
    }
}


class testL21{
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
    }

}
