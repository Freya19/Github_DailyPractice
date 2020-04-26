package gepeng18.专题.链表;


import gepeng18.leetcode.ListNode;

public class ListUtils {
    //尾插法
    public static ListNode createListTail(int [] array){
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        if(array == null || array.length == 0){
            return null;
        }
        for(int i=0;i<array.length;i++){
            ListNode listNode = new ListNode(array[i]);
            tail.next = listNode;
            tail = tail.next;
        }
        tail.next = null;
        return dummyNode.next;
    }

    //头插法
    public static ListNode createListHead(int [] array){
        ListNode head = new ListNode(0);
        if(array == null || array.length == 0){
            return null;
        }
        for(int i=0;i<array.length;i++){
            //创建一个节点
            ListNode listNode = new ListNode(array[i]);

            listNode.next = head.next;
            head.next = listNode;
        }

        return head.next;
    }



    public static void printList(ListNode listNode){
        if(listNode == null){
            System.out.println("啥都没有，你让我打印啥 ----- 空指针喽");
        }
        ListNode current = listNode;
        StringBuilder stringBuilder = new StringBuilder();
        while(current!=null){
            stringBuilder.append(current.val+" -> ");
            current = current.next;
        }
        String result = stringBuilder.toString();
        result = result.substring(0, result.length() - 3);
        System.out.println(result);

    }

    //删除值为x的元素
    //一般传入的节点都是带数据的节点，所以像删除这种操作都是需要记录前一个节点的操作，可以使用dummyNode
    public  static void delete(ListNode head,int x){
        if(head==null)
            return ;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode current = dummyNode;
        while(current.next!=null){
            //current.next是否为指定值，是则删除
            if(current.next.val==x)
                //这里稍微有点特殊，如果把下一个删了，那下下的一个抵上来，可能还需要删除
                current.next = current.next.next;
            else
                current = current.next;
        }

    }

    //参考： https://blog.csdn.net/xu491361421xiao/article/details/81385435
    //问我，不要自己看
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) //链表为空或者仅1个数直接返回
            return head;
        ListNode current = head, newHead = null;
        while (current != null)                 //一直迭代到链尾
        {
            ListNode next = current.next;          //暂存p下一个地址，防止变化指针指向后找不到后续的数
            current.next = newHead;               //current.next指向前一个空间

            //调整指针
            newHead = current;                     //新链表的头移动到p，扩长一步链表
            current = next;                   //p指向原始链表p指向的下一个空间
        }
        return newHead;
    }

    //问我，不要自己看
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        //向后移动m次，找到第m个元素的前面一个元素
        for(int i = 0; i < m;i++){
            pre = pre.next;
        }
        ListNode thisNode =pre.next;
        ListNode next = thisNode.next;

        for(int i = 0; i < n-m; i++){
            thisNode.next = next.next;
            next.next = pre.next;
            pre.next = next;

            next = thisNode.next;
        }
        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode = ListUtils.createListTail(new int[]{1, 2, 3, 4});
        final ListNode newList = ListUtils.reverseBetween(listNode, 1, 2);
        ListUtils.printList(newList);
    }
}
