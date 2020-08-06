package gepeng18.专题.二分查找.林沐.相关题目;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 */
public class L540有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int begin = 0, end = nums.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            mid = mid % 2 == 0 ? mid : mid - 1;
            // mid-1不存在
            if(mid == 0 &&  nums[mid] != nums[mid + 1])
                return nums[mid];
            // mid+1不存在
            else if (mid == nums.length-1 &&  nums[mid] != nums[mid - 1])
                return nums[mid];
            // mid-1 mid+1都存在
            else if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1] )
                return nums[mid];
            else if (nums[mid] != nums[mid + 1])
                end = mid - 2;
            else
                begin = mid + 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        final int res = new L540有序数组中的单一元素().singleNonDuplicate(new int[]{3, 3, 7, 7,  11, 11, 12, 12,13});
        System.out.println(res);
    }
}
