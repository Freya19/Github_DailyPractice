package freya19.practice.算法题和数据结构.堆;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;

public class SO40最小的k个元素 {

    int[] res ;

    public int[] getLeastNumbers(int[] arr, int k) {

        res = new int[k];
        if (k > arr.length || k <= 0) {
            return  res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

//        new StringBuilder();
//        new StringBuffer();

        int i=0;
        while (!maxHeap.isEmpty()){
            res[i++]=maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(0);

        new TreeMap<>();
        new HashMap<>();

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }
}
