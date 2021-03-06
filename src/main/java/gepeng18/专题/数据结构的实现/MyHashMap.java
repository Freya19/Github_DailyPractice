package gepeng18.专题.数据结构的实现;


/**
 * 自定义一个HashMap
 * 实现get方法，根据键对象获得对应的值对象
 *
 * @author 高淇
 */
public class MyHashMap<K, V> {

    class Node<K, V> {
        int hash;
        K key;
        V value;
        Node next;
    }

    /**
     *     位桶数组。bucket  array
     */
    Node[] table;
    /**
     * 存放的键值对的个数
     */
    int size;

    public MyHashMap() {
        //长度一般定义成2的整数幂
        table = new Node[16];
    }


    public V get(K key) {

        int hash = myHash(key.hashCode(), table.length);
        V value = null;

        if (table[hash] != null) {
            Node current = table[hash];

            while (current != null) {
                //如果相等，则说明找到了键值对，返回相应的value
                if (current.key.equals(key)) {
                    value = (V) current.value;
                    break;
                } else {
                    current = current.next;
                }
            }

        }

        return value;
    }


    public void put(K key, V value) {

        //如果要完善，还需要考虑数组扩容的问题！！！

        //定义了新的节点对象
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node current = table[newNode.hash];

        // 最后一个节点
        Node lastNode = null;
        boolean keyRepeat = false;
        if (current == null) {
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        } else {
            //此处数组元素不为空。则遍历对应链表。。
            while (current != null) {

                //判断key如果重复，则覆盖
                if (current.key.equals(key)) {
                    keyRepeat = true;
                    //只是覆盖value即可。其他的值(hash,key,next)保持不变。
                    current.value = value;

                    break;

                } else {
                    //key不重复，则遍历下一个。
                    lastNode = current;
                    current = current.next;

                }
            }

            //没有发生key重复的情况，则添加到链表最后。
            if (!keyRepeat) {
                lastNode.next = newNode;
                size++;
            }
        }
    }


    @Override
    public String toString() {
        //{10:aa,20:bb}
        StringBuilder sb = new StringBuilder("{");

        //遍历bucket数组
        for (int i = 0; i < table.length; i++) {
            Node temp = table[i];

            //遍历链表
            while (temp != null) {
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();

    }


    public static void main(String[] args) {
        MyHashMap<Integer, String> m = new MyHashMap<>();
        m.put(10, "aa");
        m.put(20, "bb");

        System.out.println(m.get(85));

    }


    public static int myHash(int v, int length) {
        //直接位运算，效率高
        return v & (length - 1);
    }


}



