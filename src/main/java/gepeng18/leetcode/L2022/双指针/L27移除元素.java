package gepeng18.leetcode.L2022.双指针;

public class L27移除元素 {

	// 需要保证 nums[0..slow] 是不包含值为 val 的元素的
	int removeElement(int[] nums, int val) {
		int fast = 0, slow = 0;
		while (fast < nums.length) {
			if (nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}
}
