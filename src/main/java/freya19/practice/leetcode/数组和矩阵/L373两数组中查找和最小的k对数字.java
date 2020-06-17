package freya19.practice.leetcode.数组和矩阵;

import java.util.*;

/**
 * 数组升序排列
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */
public class L373两数组中查找和最小的k对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return null;
        }

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, cmp);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(nums1[i] + nums2[j]);
                res.add(nums1[i] + nums2[j], Arrays.asList(nums1[i], nums2[j]));
                if (pq.size() > k) {
                    Integer pqPoll = pq.poll();
                    res.remove(pqPoll);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 7, 11};
        int[] n2 = {2, 4, 6};

        List<List<Integer>> ret = new L373两数组中查找和最小的k对数字().kSmallestPairs(n1, n2, 3);
        System.out.println(ret);
    }
}