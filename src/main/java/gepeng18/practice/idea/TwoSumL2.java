package gepeng18.practice.idea;

//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { this.val = x; }
}
class SolutionL2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        while(l1!=null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int realValue = sum%10;
            carry = sum / 10;
            ListNode newNode = new ListNode(realValue);
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null){
            while(l2!=null){
                int sum = l2.val+carry;
                int realValue = sum%10;
                carry = sum / 10;
                ListNode newNode = new ListNode(realValue);
                current.next = newNode;
                current = current.next;
                l2 = l2.next;
            }
        }
        if(l2==null){
            while(l1!=null){
                int sum = l1.val+carry;
                int realValue = sum%10;
                carry = sum / 10;
                ListNode newNode = new ListNode(realValue);
                current.next = newNode;
                current = current.next;
                l1 = l1.next;
            }
        }
        if(carry!=0) {
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
            current = current.next;
        }
        return dummyNode.next;
    }
}
public class TwoSumL2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = SolutionL2.addTwoNumbers(l1,l2);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
