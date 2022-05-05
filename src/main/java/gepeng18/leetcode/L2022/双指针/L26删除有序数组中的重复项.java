package gepeng18.leetcode.L2022.双指针;

public class L26删除有序数组中的重复项 {

	// 维护0-slow数组是不重复的，所以slow指向的数据是从未重复的
	int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != nums[slow]) {
				slow++;
				// 维护 nums[0..slow] 无重复
				nums[slow] = nums[fast];
			}
			fast++;
		}
		// 数组长度为索引 + 1
		return slow + 1;
	}

}
