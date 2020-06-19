package freya19.practice.leetcode.数组和矩阵;

import freya19.practice.动态规划.L64最小路径和;

import java.util.Arrays;

/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
 * 导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，
 * 再找到丢失的整数，将它们以数组的形式返回。
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 */

public class L645错误的集合 {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int[] counts= new int[n+1];

        for(int num:nums){
            counts[num]++;
        }

        int[] res = new int[2];
        for(int i=1;i<counts.length;i++){
            if(counts[i]==2){
                res[0]=i;
            }else if(counts[i]==0){
                res[1]=i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums={2,1,4,2};
        int[] ret = new L645错误的集合().findErrorNums(nums);
        System.out.println(Arrays.toString(ret));
    }
}
