package gepeng18.专题.数据结构的实现;

public class LinkedList<T> {
    class Node {
        Node next;            //下一个节点
        T element;            //元素数据

        public Node(T element) {
            this.element = element;
        }

    }

    Node head;
    Node tail;

    public LinkedList() {
        head = tail = new Node(null);
    }

    public void add(T element) {
        Node newNode = new Node(element);
        tail.next = newNode;
        tail = newNode;
    }

    public T remove() {
        if (head == tail) {
            return null;
        }
        Node cur = head.next;
        head.next = cur.next;
        if (cur.next == null)
            tail = head;
        return cur.element;
    }

    public void remove(T element) {
        if (head == tail) {
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.element.equals(element)) {
                cur.next = cur.next.next;
            } else{
                cur = cur.next;
            }
        }
        if (head.next == null)
            tail = head;
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add("1");
        queue.add("2");
        queue.remove("1");
        queue.remove("2");
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
