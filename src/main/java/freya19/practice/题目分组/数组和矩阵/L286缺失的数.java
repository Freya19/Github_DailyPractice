package freya19.practice.题目分组.数组和矩阵;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */

public class L286缺失的数 {

    /**
     * 非常数级空间
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {

        int res = 0;

        if (nums == null || nums.length == 0) {
            return res;
        }

        int n = nums.length;
        int[] freq = new int[n + 1];
        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 0; i < n + 1; i++) {
            if (freq[i] == 0) {
                res = i;
            }
        }
        return res;
    }

    /**
     * 常数级空间（原数组上操作）
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        //right是不缺少数字时的最后一位索引
        int left = 0, right = nums.length;
        while (left <= right) {
            int cnt = 0;
            int mid = left + right >>> 1;

            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            if (cnt > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


}
