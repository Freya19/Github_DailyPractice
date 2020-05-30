package gepeng18.专题.二分查找;

import gepeng18.专题.数组.L566改变矩阵维度;

import java.nio.charset.MalformedInputException;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L540有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        return -1;
    }

    public static void main(String[] args) {
        final int res = new L540有序数组中的单一元素().singleNonDuplicate(new int[]{3,3,7,7,10,11,11
});
        System.out.println(res);
    }
}
