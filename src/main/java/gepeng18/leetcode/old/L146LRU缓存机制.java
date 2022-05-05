package gepeng18.leetcode.old;

import java.util.*;

public class L146LRU缓存机制 {
    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

    public L146LRU缓存机制(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "3");
        map.put(2, "2");
        map.put(1, "5");
        map.put(10, "5");
        map.put(898, "5");
        map.put(11111, "5");
        map.put(353463446, "5");
        map.put(8, "5");
        map.put(15, "5");
        map.put(4, "5");
        map.put(6, "5");
        map.put(7, "5");
        map.put(9, "5");
        for (int i = 0; i < 100; i++) {

            for (Integer integer : map.keySet()) {
                System.out.println(integer);
            }
            System.out.println("*******************************************");
        }

    }
}
