package gepeng18.笔试.阿里巴巴2021;

import java.util.Scanner;

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

            if (r - l + 1 == k)
                min = Math.min(min, sum);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int min = 0;
        int[] nums = new int[times];
        for (int i = 0; i < times; i++)
            nums[i] = scanner.nextInt();

        for (int i = 1; i <= times; i++){
            min = new 小强集训队().solve(nums, i);
            System.out.println(min);
        }

    }

}
