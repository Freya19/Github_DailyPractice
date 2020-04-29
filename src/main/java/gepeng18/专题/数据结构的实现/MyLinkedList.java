package gepeng18.专题.数据结构的实现;


/**
 * 自定义一个链表
 * 增加小的封装、增加泛型
 *
 * @author Administrator
 */

public class MyLinkedList<E> {

    public class Node {
        Node previous;        //上一个节点
        Node next;                //下一个节点
        Object element;        //元素数据

        public Node(Node previous, Node next, Object element) {
            super();
            this.previous = previous;
            this.next = next;
            this.element = element;
        }

        public Node(Object element) {
            super();
            this.element = element;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void add(int index, E element) {   //alt+shift+R

        checkRange(index);

        Node newNode = new Node(element);
        Node originalNode = getNode(index);

        if (originalNode != null) {
            Node before = originalNode.previous;

            before.next = newNode;
            newNode.previous = before;

            newNode.next = originalNode;
            originalNode.previous = newNode;

        }


    }

    public void add(E element) {
        Node node = new Node(element);

        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }

        size++;
    }

    public void remove(int index) {

        checkRange(index);

        Node temp = getNode(index);

        if (temp != null) {
            Node before = temp.previous;
            Node after = temp.next;

            if (before != null) {
                before.next = after;
            }

            if (after != null) {
                after.previous = before;
            }

            //被删除的元素是第一个元素时
            if (index == 0) {
                first = after;
            }

            //被删除的元素是最后一个元素时
            if (index == size - 1) {
                last = before;
            }

            size--;
        }

    }

    public E get(int index) {

        checkRange(index);

        Node temp = getNode(index);

        return temp != null ? (E) temp.element : null;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法:" + index);
        }
    }

    private Node getNode(int index) {
        checkRange(index);

        Node temp = null;
        if (index <= (size >> 1)) {   //size>>1相当于除以2
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }

        return temp;
    }

    @Override
    public String toString() {
        //[a,b,c]     first=a,    last=c
        //a,b,c
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');

        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("a");
        list.add("b");

        System.out.println(list);

        System.out.println(list.get(1));
    }


}

