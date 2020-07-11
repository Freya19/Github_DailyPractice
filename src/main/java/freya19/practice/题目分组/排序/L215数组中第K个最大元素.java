package freya19.practice.题目分组.排序;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:输入: [3,2,1,5,6,4] 和 k = 2 。输出: 5
 * 示例 2:输入: [3,2,3,1,2,4,5,5,6] 和 k = 4 。输出: 4
 * 说明:你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class L215数组中第K个最大元素 {
    /**
     * 排序 O(nlogn)
     * @return
     */

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 优先队列-----默认升序排列（2 3 4），出队时先出小的（所以确实是 小顶堆）
     * O(nlogk)
     */
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}