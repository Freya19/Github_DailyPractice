package gepeng18.专题.回溯;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class L40组合总数II {
    //定义全局变量保存最终结果
    private List<List<Integer>> res = new ArrayList<>();

    private Set<List<Integer>> set = new HashSet<>();

    //已经选的数为state，还可以选p-最后，count为已经加了的数
    public void back(int[] candidates, int target, List state, int p, int count) {
        if(count>target)
            return ;

        if (count == target ) {
            if(!set.contains(state)){
                set.add(state);
                res.add(state);
            }
            return;
        }

        for (int i = p; i < candidates.length; i++) {
            int tmpCount = count + candidates[i];
            List<Integer> tmpState = new ArrayList(state);
            tmpState.add(candidates[i]);
            back(candidates, target, tmpState, i + 1, tmpCount);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        Arrays.sort(candidates);
        back(candidates, target, state, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        new L40组合总数II().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
    }
}
