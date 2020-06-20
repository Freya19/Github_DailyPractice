package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class L46全排列2 {
    private ArrayList<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        // 基本数据类型boolean都是
        boolean [] used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, used, p);
        return res;
    }

    //tmpState中保存了目前的已经产生的数据
    private void generatePermutation(int[] nums, boolean [] used,LinkedList<Integer> state){
        //什么时候停？
        if(state.size() == nums.length){
            res.add((LinkedList<Integer>)state.clone());
            return;
        }
        //1 2 3 4
        //2 3 1
        //2 3 4
        for(int i = 0 ; i < nums.length ; i ++)
            //从剩下的数据中挑选一次，继续增加状态，但是要保持初始状态不变
            if(!used[i]){
                boolean[] newUsed = Arrays.copyOf(used, used.length);
                newUsed[i] = true;

                final LinkedList<Integer> tmpState = new LinkedList<>(state);
                tmpState.add(nums[i]);
                generatePermutation(nums, newUsed ,tmpState );
            }
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