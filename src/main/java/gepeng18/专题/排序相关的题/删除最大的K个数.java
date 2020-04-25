package gepeng18.专题.排序相关的题;

import gepeng18.test.P;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个数组，删除其中最大的K个数
 */
public class 删除最大的K个数 {
    class Element {
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] deleteTopK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Element> pq = new PriorityQueue<>((e1, e2) -> e2.value - e1.value);
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < arr.length-k) {
                pq.offer(new Element(arr[i], i));
            } else if (arr[i] < pq.peek().value) {
                pq.poll();
                pq.offer(new Element(arr[i], i));
            }
        }

        int[] hash = new int[arr.length];
        int count = 0;
        for (Element e : pq) {
            if (count == arr.length - k)
                break;
            hash[e.index] = 1;
            count++;
        }

        int[] result = new int[arr.length - k];

        int resultIndex = 0;
        for (int i = 0; i < hash.length; i++)
            if (hash[i] == 1)
                result[resultIndex++] = arr[i];
        return result;
    }

    public static void main(String[] args) {
        final int[] results = new 删除最大的K个数().deleteTopK(new int[]{1, 5, 2, 7, 8, 2}, 2);
        for(int r:results) {
            System.out.println(r);
        }
    }
}

