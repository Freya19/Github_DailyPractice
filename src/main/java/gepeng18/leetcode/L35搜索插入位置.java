package gepeng18.leetcode;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2

 */
public class L35搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        while (index < nums.length && nums[index] < target)
            index++;

        if (index == nums.length)
            return index;

        if (nums[index] == target)
            return index;
        else
            return index;

//        throw new RuntimeException("出错啦");

    }


    public static void main(String[] args) {
        int [] data = {1,3,5,6};
        int target = 0;
        int i = searchInsert(data, target);
        System.out.println(i);
    }
}
