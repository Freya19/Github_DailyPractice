package gepeng18.专题.队列;

import java.util.ArrayDeque;

/**
 * 方法二：双向队列
 *
 * 直觉
 *
 * 如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。在大小为 k 的堆中插入一个元素消耗 log⁡(k)\log(k)log(k) 时间，因此算法的时间复杂度为 O(Nlog⁡(k)){O}(N \log(k))O(Nlog(k))。
 *
 *     能否得到只要 O(N) 的算法？
 *
 * 我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
 *
 * 存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
 *
 * 算法
 *
 * 算法非常直截了当：
 *
 *     处理前 k 个元素，初始化双向队列。
 *
 *     遍历整个数组。在每一步 :
 *
 *     清理双向队列 :
 *
 *       - 只保留当前滑动窗口中有的元素的索引。
 *
 *       - 移除比当前元素小的所有元素，它们不可能是最大的。
 *
 *     将当前元素添加到双向队列中。
 *     将 deque[0] 添加到输出中。
 *     返回输出数组。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class L239滑动窗口最大值 {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // i是第i个元素，k是滑动窗口的值，所以 当 i==2,k==2时，如果队列中还有0，则需要删除。
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // 尾巴处比当前元素小的，都给删掉
        while (!deq.isEmpty() && nums[i] >= nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // 第一步：先找出前k个元素的最大值
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            //插入第i个，总数为K个
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx])
                max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // 第二步：找出后面的滑动窗口的最大值
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }
}
