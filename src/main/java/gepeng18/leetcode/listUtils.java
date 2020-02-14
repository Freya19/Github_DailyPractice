package gepeng18.leetcode;

public class listUtils {
    public static ListNode createList(int [] array){
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        if(array == null || array.length == 0){
            return null;
        }
        for(int i=0;i<array.length;i++){
            ListNode listNode = new ListNode(array[i]);
            current.next = listNode;
            current = current.next;
        }
        current.next = null;
        return dummyNode.next;

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

    public static void main(String[] args) {
        ListNode listNode = listUtils.createList(new int[]{1, 2, 3, 4});
        listUtils.printList(listNode);
    }
}
