package freya19.practice.算法题和数据结构.双指针;

/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1:
给定数组 nums = [1,1,2],
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。
 */
public class L26双指针之删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;

        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] == nums[fast]) {  //fast和fast-1处不同的时候，把fast对应元素赋值给slow处；相同则直接fast++；
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

}
