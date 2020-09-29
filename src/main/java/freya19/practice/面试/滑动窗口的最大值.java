package freya19.practice.面试;

import gepeng18.test.OOM.HeapOOM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {

    // winSize —— 滑动窗口大小
    public List<Integer> max(int[] nums, int winSize) {

        // 结果集合
        ArrayList<Integer> res = new ArrayList<>();

        // 不满足的条件
        if (winSize > nums.length || winSize < 1) {
            return res;
        }

        // 窗口内元素找出最大值 —— 用大顶堆，大顶poll出来
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 大顶堆 初始化
        for (int i = 0; i < winSize; i++) {
            maxHeap.add(nums[i]);
        }
        res.add(maxHeap.peek());

        for (int i = 0, j = i + winSize; j < nums.length; i++, j++) {
            // 维护大顶堆大小为winSize，后一个元素来了，删掉前一个窗口的元素   1 2 3 4  —— 1 2 3 ———— 2 3 4
            maxHeap.remove(nums[i]); // 删掉了1
            maxHeap.add(nums[j]);  // 加入 4
            res.add(maxHeap.peek()); // peek出来的是 3
        }
        return res;
    }
}
