package gepeng18.leetcode.old;

import javafx.util.Pair;

import java.util.*;


public class L347前K个高频元素 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);

        }
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue((o1, o2)->{return (Integer) ((Pair)o1).getValue()- (Integer) ((Pair)o2).getValue();});

        for(Integer num: map.keySet()){
            int numFreq = map.get(num);
            if(queue.size() == k){
                if(numFreq > queue.peek().getValue()){
                    queue.poll();
                    queue.add(new Pair(num, numFreq));
                }
            }
            else
                queue.add(new Pair(num, numFreq));
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty())
            list.add(queue.poll().getKey());
        return list;
    }

    public static void main(String[] args) {
        final List<Integer> integers = new L347前K个高频元素().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        integers.forEach(System.out::println);
    }
}
