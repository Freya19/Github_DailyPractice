package freya19.practice.leetcode;

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

/*
四步：
    全局变量：res = []   List<List<Integer>>
    参数设计：（1）状态变量：当前选用过的数字（2）条件变量：剩余的备选数字 和 当前数字的总和。
    完成条件：当数字总和等于target了，就加入到res；当大于target了，则不再搜索；当小于target了，就继续搜索。
    递归过程：如果当前总和小于target就继续搜索。
 */
public class L40回溯之组合总和二 {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();  //存放每次判断后的状态，再用其判断是否之前存过这个状态
    // 递归找和为target的数字们
    private void findSum(int[] nums, int target, List<Integer> state, int p, int sum) {
        for (int i = p; i < nums.length; i++) {
            int tempSum = sum + nums[i];

            List<Integer> tempState = new ArrayList<>(state);
            tempState.add(nums[i]);

            if (tempSum < target) {
                findSum(nums, target, tempState, i + 1, tempSum);
            } else {
                if (tempSum == target && !set.contains(tempState)) {
                    set.add(tempState);
                    res.add(tempState);
                }
                return;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates,target,state,0,0);
        return res;
    }

    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};

        L40回溯之组合总和二 l40 = new L40回溯之组合总和二();
        List<List<Integer>> lists = l40.combinationSum2(nums, 8);

        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }
    }
}
