package gepeng18.专题.回溯;

import java.util.*;

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
