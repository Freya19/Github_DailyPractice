package gepeng18.test;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class priorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue((o1,o2)->{return (Integer)o2-(Integer)o1;});
        queue.add(7);
        queue.add(1);

        queue.add(2);
        while(!queue.isEmpty())
        {
            System.out.println(queue.poll());
        }
    }


}



