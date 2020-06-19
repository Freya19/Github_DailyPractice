package gepeng18.专题.回溯;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class L46全排列 {
    private ArrayList<List<Integer>> res;
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        // 基本数据类型boolean都是
        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums,  p);
        return res;
    }

    //state中保存了目前的已经产生的数据
    private void generatePermutation(int[] nums, LinkedList<Integer> state){
        if(state.size() == nums.length){
            res.add((LinkedList<Integer>)state.clone());
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
            if(!used[i]){
                used[i] = true;
                state.add(nums[i]);
                generatePermutation(nums,  state );
                state.removeLast();
                used[i] = false;
            }
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new L46全排列()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}