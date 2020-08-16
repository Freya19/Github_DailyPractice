package freya19.practice.算法题和数据结构.动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L231打家劫舍_2_动态规划 {

    int[] memo1;
    int[] memo2;
    public int rob(int[] nums) {

        int n = nums.length;

        memo1 = new int[n + 1];
        Arrays.fill(memo1, -1);
        memo2 = new int[n + 1];
        Arrays.fill(memo2, -1);

        if (nums.length == 1) {
            return nums[0];
        }

        int max = Math.max(myFirstRob(nums, n - 2), mySecondRob(nums, n - 1));
        return max;

    }

    // 0 - n-2
    private int myFirstRob(int[] nums,  int end) {
        int n = nums.length;

        if (memo1[end] != -1) {
            return memo1[end];
        }

        if(end == 0)
            return nums[0];
        if(end == 1)
            return Math.max(nums[0],nums[1]);

        int res = Math.max(myFirstRob(nums,end-2)+nums[end],myFirstRob(nums,end-1));
        memo1[end] = res;

        return res;
    }

    private int mySecondRob(int[] nums,  int end) {
        int n = nums.length;

        if (memo2[end] != -1) {
            return memo2[end];
        }

        if(end == 1)
            return nums[1];
        if(end == 2)
            return Math.max(nums[1],nums[2]);

        int res = Math.max(myFirstRob(nums,end-2)+nums[end],myFirstRob(nums,end-1));
        memo2[end] = res;

        return res;
    }
}
