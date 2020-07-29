package gepeng18.专题.滑动窗口;

/**
 * 和如果大于0，则右指针右移
 * 和如果小于0，则左指针右移
 *
 * 每次循环计算和的最大值
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
