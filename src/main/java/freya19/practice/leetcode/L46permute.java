package freya19.practice.leetcode;
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
import java.util.LinkedList;
import java.util.List;

public class L46permute {
    List<List<Integer>> res;
    private boolean[] used;

    // 类比于数列求通项公式：这个permute方法，相当于递推式的S(n)，光有这个是求不出来的，还需要S(n-1)的表达式
    // 递归过程就是permute(nums[0...n-1]) = {取出一个数字} + permute(nums[{0...n-1}-这个数字])
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();

        if(nums==null || nums.length==0) return res;

        used = new boolean[nums.length];  // used按传入的nums大小进行初始化（初始化全是false）
        LinkedList<Integer> temp = new LinkedList<>();
        generatePermutation(nums,0,temp);

        return res;
    }

    // 从index开始选数字排列，temp中存的是前index-1 个数字排列的结果
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    public void generatePermutation(int[] nums, int index, LinkedList<Integer> temp){
        // 递归终止条件
        if(nums.length==index){
            res.add((LinkedList<Integer>)temp.clone());  //浅拷贝
//            res.add(temp);  // 如果这里不这样clone并转型的话，输出就全部都是空
            return;
        }

        for(int i=0;i<nums.length;i++){
           if(!used[i]){
               used[i] = true;
               temp.addLast(nums[i]);
               generatePermutation(nums,index+1,temp);
               temp.removeLast();
               used[i]=false;
           }
        }
//        return;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        L46permute p = new L46permute();
        List<List<Integer>> llist = p.permute(nums);

        for(List<Integer> list: llist){
            System.out.println(list);
        }
    }
}
