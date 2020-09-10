package gepeng18.笔试.阿里巴巴2021;

public class 小强集训队 {
    // 连续子数组和
    public static int solve(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int l = 0, r = -1;
        int sum = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && r - l + 1 < k) {
                r++;
                sum += nums[r];
            } else {
                l++;
                sum -= nums[l - 1];
            }

            if (r - l + 1 == k) min = Math.min(min, sum);
        }
        return min;
    }

    public static void main(String[] args) {

        int min = new 小强集训队().solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
        System.out.println(min);

    }

}
