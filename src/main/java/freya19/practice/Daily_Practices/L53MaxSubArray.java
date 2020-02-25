package freya19.practice.Daily_Practices;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class L53MaxSubArray {
    public int maxSubArray(int[] nums){
        int maxCurr = nums[0];
        int maxSum = nums[0];
        for(int i =1;i<nums.length;i++){
            maxCurr = Math.max(maxCurr + nums[i],nums[i]);
            maxSum = Math.max(maxCurr,maxSum);
            /*
                        -1        2           3           -1
                                -1+2=1      2+3=5        5-1=4
               maxCurr  -1      1和2取2     5和3取5     4和-1取4
               maxSum   -1      2和-1取2    5和2取5     4和5 取5

               最终得到：5
             */

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1,2,3,-1};
        int[] arr2 = {-1,-2,3,-1};

        L53MaxSubArray msa = new L53MaxSubArray();
        System.out.println(msa.maxSubArray(arr1));
        System.out.println(msa.maxSubArray(arr2));

    }
}
