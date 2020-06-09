package freya19.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。

示例:
输入: nums = [1,2,3]
输出:
[   [3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]  ]
 */
public class L78子集 {
    public List<List<Integer>> subsets(int[] nums) {
        return getSubsets(nums, nums.length - 1);
    }

    //0~index索引范围内的子集
    public List<List<Integer>> getSubsets(int[] nums, int index) {

        List<List<Integer>> result = new ArrayList<>();

        //递归终止条件
        if (index == 0) {
            result.add(new ArrayList<>());
            result.add(new ArrayList<>(Arrays.asList(nums[index])));
//            result.add(new ArrayList<>(nums[index]));  // 也不能用
            return result;
        }

        // 0~index-1索引范围内的子集
        List<List<Integer>> subsets = getSubsets(nums, index - 1);

        //找到0~index-1范围内的子集后，处理加上index后的子集
        for (List<Integer> subset : subsets) {
            result.add(new ArrayList<>(subset));  //不可以直接将subset 添加到result中
            subset.add(nums[index]);
            result.add(new ArrayList<>(subset));  //不可以直接将subset 添加到result中
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        L78子集 l78 = new L78子集();
        List<List<Integer>> res = l78.subsets(nums);

        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }


}
