package freya19.practice.题目分组.双指针;
/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:   输入: [1,3,4,2,2]     输出: 2
示例 2:   输入: [3,1,3,4,2]     输出: 3

说明：
    不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。
 */

public class L287寻找重复的数字 {

    /**
     *  一种炫酷的二分法，“抽屉”原理
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            //无符号右移（就是除以2，如果left + right溢出也不会出错）
            int mid = left + right >>> 1;

            //遍历数组，找到比mid小的元素统计个数
            int ctn = 0;
            for (int num : nums) {
                if (num <= mid) {
                    ctn++;
                }
            }

            //如果统计的这个个数ctn比mid大（ctn>mid），那么这个重复元素就包含在[left,mid]区间
            if (ctn > mid) {
                right = mid;
            } else //否则的话（ctn<=mid），那么这个重复元素就包含在[mid+1,right]区间
            {
                left = mid + 1;
            }
        }
        //最终，能找到这个重复的元素，且为left
        return left;
    }
}
