package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3 ]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class L78子集_副本版本 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();

        for (int size = 0; size <= nums.length; size++) {
            // 不同的子集大小
            backtracking(0, tempSubset, subsets, size, nums);
        }
        return subsets;
    }

    //state 这个子集
    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
                              final int size, final int[] nums) {

        if (tempSubset.size() == size) {
            subsets.add(tempSubset);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            final ArrayList<Integer> cur = new ArrayList<>(tempSubset);
            cur.add(nums[i]);
            backtracking(i + 1, cur, subsets, size, nums);
        }
    }
}
