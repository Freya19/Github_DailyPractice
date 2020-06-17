package gepeng18.专题.数组;

import java.util.*;

public class L373两数组和最小的K对数字 {
    static class Num {
        int num1 = 0;
        int num2 = 0;
        int sum = 0;

        public Num(int num1, int num2, int sum) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }

        //大顶堆  e1 大  e2 小
        Comparator<Num> cmp = new Comparator<Num>() {
            @Override
            public int compare(Num e1, Num e2) {
                return e2.sum - e1.sum;
            }
        };

        PriorityQueue<Num> pq = new PriorityQueue<Num>(k, cmp);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new Num(nums1[i], nums2[j], nums1[i] + nums2[j]));
                if(pq.size()>k) {
                    pq.poll();
                }
            }
        }

        final ArrayList<List<Integer>> res = new ArrayList<>();

        while (!pq.isEmpty()){
            final Num num = pq.poll();
            final ArrayList<Integer> list = new ArrayList<>();
            list.add(num.num1);
            list.add(num.num2);
            res.add(list);
        }
    return res;

}

    public static void main(String[] args) {
        int[] n1 = {1, 7, 11};
        int[] n2 = {2, 4, 6};

        List<List<Integer>> ret = new L373两数组和最小的K对数字().kSmallestPairs(n1, n2, 3);
        System.out.println(ret);
    }
}
