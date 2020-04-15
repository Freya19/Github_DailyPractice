package gepeng18.专题.回溯;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class L90子集II {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet();

    void back(int[] nums,List state, int q)
    {
        if(set.contains(state))
            return;
        else
        {
            set.add(state);
            res.add(state);
        }
        for(int i=q;i<nums.length;i++){
            final ArrayList tmp = new ArrayList<>(state);
            tmp.add(nums[i]);
            back(nums,tmp,i+1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> state = new ArrayList<>();
        Arrays.sort(nums);
        back(nums,state,0);
        return res;
    }
}
