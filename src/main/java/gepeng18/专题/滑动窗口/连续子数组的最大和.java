package gepeng18.专题.滑动窗口;

public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum < 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }

    public static void main(String[] args) throws InterruptedException {
        while (true)
            Thread.sleep(100000);
    }
}
