package freya19.practice.滑动窗口;
/*
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
如果不存在符合条件的连续子数组，返回 0。返回的是子数组的长度

示例:
输入: s = 7, nums = [2,3,1,2,4,3]     输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

进阶:
如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(nlogn) 时间复杂度的解法
 */

public class L209长度最小子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null)
            throw new IllegalArgumentException("illegal argument");

        // 初始化
        int sum = 0;
        int l = 0, r = -1; // [l,r]为空
        int res = nums.length + 1;

        //维护滑动窗口
        while (l < nums.length) {  // r=-1
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];

            } else {  // r+1越界了 或者 sum >= s了
                //先将l处的元素给减去
                sum -= nums[l];
                l++;
            }

            if (sum >= s)
                res = Math.min(res, r - l + 1);
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new L209长度最小子数组().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
