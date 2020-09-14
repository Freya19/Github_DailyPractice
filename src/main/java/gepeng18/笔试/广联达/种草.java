package gepeng18.笔试.广联达;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 种草 {

    public static int solve(int [] nums,int m,int x){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 小  大
                return o1 - o2;
            }
        });
        for (int num:nums){
            queue.add(num);
        }
        for (int i = 0;i<m;i++){
            Integer cur = queue.poll();
            queue.add(cur+x);
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int res = solve(new int[]{1, 2, 3}, 1, 5);
        System.out.println(res);
    }

}
