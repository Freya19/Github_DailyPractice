package freya19.practice.leetcode.回溯;
/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L46全排列重写 {

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }

        int[] used = new int[nums.length];
        ArrayList<Integer> state = new ArrayList<>();

        prePermute(nums,used,state);

        return res;
    }


    /**
     * [index, candidate.length)范围内考虑
     *
     * @param candidates 原数组
     * @param used       当前元素是否被用过的判断标志
     * @param state      已经考虑过的满足条件的  “ 状态 ”
     */
    public void prePermute(int[] candidates, int[] used, List<Integer> state) {

        if (state.size()==candidates.length) {
            res.add(state);
//            res.add((LinkedList<Integer>)state.clone());
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> tmpState = new ArrayList<>(state);
            if(used[i]==0){
                int[] newUsed = Arrays.copyOf(used,used.length);
                tmpState.add(candidates[i]);
                newUsed[i]=1;
                prePermute(candidates,newUsed,tmpState);
                newUsed[i]=0;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        L46全排列重写 p = new L46全排列重写();
        List<List<Integer>> llist = p.permute(nums);

        for (List<Integer> list : llist) {
            System.out.println(list);
        }
    }
}
