package freya19.practice.Java基础知识;

import java.util.Comparator;
import java.util.PriorityQueue;

public class tst {
    public static void main(String[] args) {
//        String a ="abc";
//        String b = new String("abc");
//        System.out.println(a==b);// false


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(7);
        maxHeap.add(4);
        maxHeap.add(10);

        // 队列应该先入先出，优先队列默认是从小到大排列的（头小尾大）；
        // 重写compare方法后，是从大到小排列了（头大尾小）
        // 输出：10、7 、5 、4、2
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }
}
