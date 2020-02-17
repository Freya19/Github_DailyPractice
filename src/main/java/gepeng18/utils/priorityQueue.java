package gepeng18.utils;


import java.util.PriorityQueue;
import java.util.Random;

public class priorityQueue {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{return o2-o1;});

    public static void main(String[] args) {
        final Random random = new Random();
        for(int i=0;i<10;i++){
            pq.offer(random.nextInt(100));
        }
        pq.forEach(System.out::println);
    }
}
