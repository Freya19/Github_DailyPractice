package freya19.practice.题目分组.回溯;

import java.util.*;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
    所有数字（包括目标数）都是正整数。
    解集不能包含重复的组合。

示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,  所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

示例 2:
输入: candidates = [2,5,2,1,2], target = 5,   所求解集为:
[
  [1,2,2],
  [5]
]
 */

public class L40组合总和二 {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 存放每次判断后的状态，再用其判断是否之前存过这个状态
     */
    Set<List<Integer>> set = new HashSet<>();

    /**
     * 考虑[curIndex,candidates-1]范围内元素
     */
    private void findSum(int[] candidates, int target, List<Integer> state, int curIndex, int sum) {

        //递归终止条件1
        if (sum > target) {
            return;
        }

        //递归终止条件2
        if (sum == target) {
            if (!set.contains(state)) {
                set.add(state);
                res.add(state);
            }
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            int tmpSum = candidates[i] + sum;
            List<Integer> tmpState = new ArrayList<>(state);
            tmpState.add(candidates[i]);
            findSum(candidates, target, tmpState, i + 1, tmpSum);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        //排序后就不会出现{[1,7],[7,1]}这种重复的现象了 ------ {10, 1, 2, 7, 6, 1, 5} ----> {1,1,2,5,6,7,10}
        Arrays.sort(candidates);

        findSum(candidates, target, state, 0, 0);
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};

        L40组合总和二 l40 = new L40组合总和二();
        List<List<Integer>> lists = l40.combinationSum2(nums, 8);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
