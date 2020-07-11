package freya19.practice.题目分组.回溯;

import java.util.*;


public class L39组合总和 {

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
            findSum(candidates, target, tmpState, i, tmpSum);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        Arrays.sort(candidates);

        findSum(candidates, target, state, 0, 0);
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,6,7};

        List<List<Integer>> ret = new L39组合总和().combinationSum(nums,7);

        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }
}
