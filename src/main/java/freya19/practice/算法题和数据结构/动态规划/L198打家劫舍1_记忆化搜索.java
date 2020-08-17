package freya19.practice.算法题和数据结构.动态规划;
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


public class L198打家劫舍1_记忆化搜索 {
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {
        //边界条件判断（类似边界情况的初始化）
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        // 偷 index 处的房子 和 不偷 index 处的房子 二者取最大值
        int res = Math.max(nums[index] + tryRob(nums, index + 2), tryRob(nums, index + 1));
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {2, 7, 1, 9, 3};

        System.out.println((new L198打家劫舍1_记忆化搜索()).rob(nums));
    }
}


//        if (index == 1) {
//            return nums[1];
//        }
//
//        if (index == 0) {
//            return nums[0];
//        }
//
//        if (memo[index] != -1) {
//            return memo[index];
//        }
//
//        int res = 0;
//        res = Math.max(res, nums[index] + tryRob(nums, index - 2));
//        memo[index] = res;
//
//        return res;