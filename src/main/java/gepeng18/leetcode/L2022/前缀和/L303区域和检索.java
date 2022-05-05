package gepeng18.leetcode.L2022.前缀和;

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 *     计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 *
 * 实现 NumArray 类：
 *
 *     NumArray(int[] nums) 使用数组 nums 初始化对象
 *     int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L303区域和检索 {
	// 前缀和数组
	private int[] preSum;

	public L303区域和检索(int[] nums) {
		preSum = new int[nums.length];
		preSum[0] = nums[0];
		for (int i = 1;i<nums.length;i++){
			preSum[i] = preSum[i-1]+ nums[i];
		}
	}

	/* 查询闭区间 [left, right] 的累加和 */
	public int sumRange(int left, int right) {
		if (left == 0){
			return preSum[right];
		}
		return preSum[right] - preSum[left-1];
	}
}
