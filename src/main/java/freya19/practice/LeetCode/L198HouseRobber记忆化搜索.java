package freya19.practice.LeetCode;
/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
能够偷窃到的最高金额。

示例 1:
输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2:
输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

import java.util.Arrays;


public class L198HouseRobber记忆化搜索 {
    private int[] memo;

    //memo[i]表示考虑偷nums[i...n)范围内房子的所得最大利益
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return tryRob(nums, 0);
    }

    // 考虑偷nums[index...nums.length-1]范围内的房子
    private int tryRob(int[] nums, int index) {
        //对index做越界的判断
        if (index >= nums.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {

        int nums[] = {2,7,9,3,1};
        System.out.println((new L198HouseRobber记忆化搜索()).rob(nums));
    }
}
