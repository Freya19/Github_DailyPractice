package freya19.practice.算法题和数据结构.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A01组合和 {

    public List<List<Integer>> res = new ArrayList<>();
    public Set<List<Integer>> set = new HashSet<>();

    public /*List<List<Integer>>*/ void back(int[] candidates, int target, int p, List<Integer> state, int sum) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            if (!set.contains(state)) {
                set.add(state);
                res.add(state);
            }
            return;
        }

        for (int i = p; i < candidates.length; i++) {
            int tmpSum = sum + candidates[i];
            List<Integer> tmpState = new ArrayList<>(state);
            tmpState.add(candidates[i]);
            back(candidates, target, i + 1, tmpState, tmpSum);
        }
    }

    // 入口函数
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        back(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
}
