package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L46全排列2 {
    private ArrayList<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        boolean [] used = new boolean[nums.length]; // 基本数据类型boolean都是
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, used,0, p);
        return res;
    }
    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, boolean [] used,int index, LinkedList<Integer> p){
        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }
        for(int i = 0 ; i < nums.length ; i ++)
            if(!used[i]){        //****************
                boolean[] newUsed = Arrays.copyOf(used, used.length);
                newUsed[i] = true;   // **************

                final LinkedList<Integer> tmpState = new LinkedList<>(p);
                tmpState.add(nums[i]);
                generatePermutation(nums, newUsed,index + 1, tmpState );
            }
        return;
    }
    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new L46全排列2()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}