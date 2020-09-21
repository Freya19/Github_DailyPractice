package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public void sovle(int index, List<Integer> state){
        res.add(new ArrayList<>(state));
        for (int i = index;i<nums.length;i++){
            state.add(nums[i]);
            sovle(i+1,state);
            state.remove(state.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        sovle(0,new ArrayList<>());
        return res;
    }
}
