/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2

示例 2:
输入: [1,3,5,6], 2
输出: 1

示例 3:
输入: [1,3,5,6], 7
输出: 4

示例 4:
输入: [1,3,5,6], 0
输出: 0

 */
package freya19.practice.Daily_Practices;

public class L35SearchInsert {
    public int searchInsert(int[] nums, int target){
        if(nums==null) return -1;
        int i =0;
        while(i<nums.length){
            if(nums[i]!=target) {
                if(target<nums[0]) return 0;
                if(target>nums[nums.length-1]) return (nums.length);
                if(nums[i]<target && nums[i+1]>target) return i+1;
                i++;
            }return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 3;

        L35SearchInsert si = new L35SearchInsert();
        System.out.println(si.searchInsert(arr,target));
    }
}
