package gepeng18.leetcode.old;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L26删除排序数组中的重复项 {
    /**
     * 方法：双指针法
     *
     *     数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要 nums[i]=nums[j]，我们就增加 j 以跳过重复项。
     *
     *     当我们遇到 nums[j]≠nums[i]时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i+1]。然后递增 i
     *         ，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     */

    public static int removeDuplicates(int[] nums) {
        int slow = 0,quick = 0;
        while(quick<nums.length){
            if(nums[slow] == nums[quick])
                quick++;
            else{
                slow++;
                nums[slow] = nums[quick];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int result = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(result);
    }
}
