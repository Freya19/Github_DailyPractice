//package freya19.practice.Daily_Practices;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///*
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//说明：解集不能包含重复的子集。
//
//示例:
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// */
//public class L78子集 {
//    public List<List<Integer>> subsets(int[] nums) {
//        //找0-n个元素的子集
//        List<List<Integer>> res = new ArrayList<>();
//
//
//    }
//
//    //找0-index个元素的子集
//    public List<List<Integer>> findSubset(int[] nums , int index){
//
//        List<List<Integer>> tempList = new ArrayList<>();
//
//        if(index ==0){
//            tempList.add(new ArrayList<>());// 空集
//            tempList.add(new ArrayList<>(nums[index]));
//        }
//        // 0~index-1个元素的子集
//        tempList = findSubset(nums,index-1);
//
//    }
//
//}
