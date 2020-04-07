package gepeng18.专题.回溯;

import java.util.*;

public class L40组合总数II {
    private List<List<Integer>> res = new ArrayList<>();  //定义全局变量保存最终结果

    private Set<List<Integer>> set = new HashSet<>();
    public void back(int[] candidates,int target,List state,int p,int count){
        for(int i=p;i<candidates.length;i++){
            int tmpCount = count+candidates[i];
            List<Integer> tmpState = new ArrayList(state);
            tmpState.add(candidates[i]);
            if(tmpCount<target){
                back(candidates,target,tmpState,i+1,tmpCount);
            }else{
                if(tmpCount==target && !set.contains(tmpState) ){
                    set.add(tmpState);
                    res.add(tmpState);
                }
                return;
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        Arrays.sort(candidates);
        back(candidates,target,state,0,0);
        return res;
    }
}
