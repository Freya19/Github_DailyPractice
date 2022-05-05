package freya19.practice.算法题和数据结构.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A02全排列 {

    List<List<Integer>> res;


    //入口函数
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        if(nums==null||nums.length==0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> state = new ArrayList<>();
        back(nums, used, state);
        return res;
    }

    //
    public void back(int[] nums, boolean[] used, List<Integer> state) {

        if (state.size() == nums.length) {
            res.add(state);  // *****************************
            return;
        }

        // 1 2 3 4
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                boolean[] newUsed = Arrays.copyOf(used, used.length);
                newUsed[i] = true;
                List<Integer> tmpState = new ArrayList<>(state);
                tmpState.add(nums[i]);
                back(nums, newUsed, tmpState);
            }
        }
    }
}
