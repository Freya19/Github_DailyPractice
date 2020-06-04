package freya19.practice.LeetCode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    /**
     *  根据传入的数组来创建一个链表，创建另一个LisNode的构造函数
     * @param arr
     */
    public ListNode(int[] arr) {
        //这里要判断传入的数组是否为空
        if (arr.length == 0 || arr == null) {
            new IllegalArgumentException("arr can not be empty");
        }
        //数组的第一个元素赋值给链表的第一个节点的值
        this.val = arr[0];
        //定义一个链表的节点，把this赋值给它
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    /**
     * 操作链表：查
     */
    ListNode findNode(int n) {
        ListNode curNode = this;
        while (curNode != null) {
            if (curNode.val == n) {
                return curNode;
            } else {
                curNode = curNode.next;
            }
        }
        return null;
    }

    // 返回以当前ListNode为头结点的链表信息字符串
    @Override //表示子类重写了父类的方法
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        ListNode curNode = this;
        while (curNode != null) {
            sb.append(Integer.toString(curNode.val));
            sb.append("——>");
            curNode = curNode.next;
        }
        ;//在链表的末尾加上 NULL
        sb.append("NULL");
        return sb.toString();
    }

    //删除一个节点
    private void delOneNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node = node.next;
        } else
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");
    }

}


