package freya19.practice.题目分组.回溯;
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。

示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
/*
四步：
    全局变量：res = List<List<Integer>>
    参数设计：（1）state：当前已经得到的子集（2）条件变量：剩余元素。
    完成条件：当前状态没有被选过，就加入到res；被选过，就停止搜索。
    递归过程：加入当前元素进入下一次递归。
 */

import java.util.*;

public class L90子集二 {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    private void findSubset(int[] arrs, List<Integer> state, int p) {
        // 递归终止条件
        if (set.contains(state)) {
            return;
        } else {
            set.add(state);
            res.add(state);
        }
        // 递归体
        for (int i = p; i < arrs.length; i++) {
            ArrayList<Integer> tempState = new ArrayList<>(state);
            tempState.add(arrs[i]);
            findSubset(arrs, tempState, i + 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> state = new ArrayList<>();
        Arrays.sort(nums);
        findSubset(nums, state, 0);
        return res;
    }

    public static void main(String[] args) {
        int[] arrays = {4,4,4,1,4};
        L90子集二 l90 = new L90子集二();
        List<List<Integer>> lists = l90.subsetsWithDup(arrays);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

}
