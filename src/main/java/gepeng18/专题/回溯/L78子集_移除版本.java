package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class L78子集_移除版本 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            // 不同的子集大小
            backtracking(0, tempSubset, subsets, size, nums);
        }
        return subsets;
    }

    //从start处开始添加，添加至tempSubset中，直至tempSubset的size = size即可
    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
                              final int size, final int[] nums) {

        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            //添加一个数
            tempSubset.add(nums[i]);
            //继续添加其他的数，其他的数交给递归完成
            backtracking(i + 1, tempSubset, subsets, size, nums);
            //移除是为了下次能够继续添加
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
}
