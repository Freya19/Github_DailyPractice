package freya19.practice.笔试.gld;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 堆_种草问题 {
    public static int solve(int[] nums, int m, int x) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 0; i < m; i++) {
            Integer cur = queue.poll();
            queue.add(cur + x);
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int res = solve(nums, m, x);
        System.out.println(res);
    }
}
