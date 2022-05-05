package gepeng18.leetcode.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L78子集 {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums,nums.length-1);
    }

    //找到0-index的所有子集
    public List<List<Integer>> subsets(int[] nums,int index) {

        List<List<Integer>> result = new ArrayList<>();
        if(index==0){
            result.add(new ArrayList<>());
            result.add(new ArrayList<>(Arrays.asList(nums[index])));
            return result;
        }

        //找到0-index-1的所有子集
        final List<List<Integer>> subsets = subsets(nums, index - 1);

        for(List<Integer> subset:subsets){
            result.add(new ArrayList<>(subset));
            subset.add(nums[index]);
            result.add(new ArrayList<>(subset));
        }
        return result;
    }

    public static void main(String[] args) {
        final List<List<Integer>> subsets = new L78子集().subsets(new int[]{1, 2,3});
        for(List<Integer> subset:subsets){
            System.out.println(subset);
        }
    }
}
