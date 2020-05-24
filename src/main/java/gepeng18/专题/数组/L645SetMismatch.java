package gepeng18.专题.数组;

/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 */
public class L645SetMismatch {

    public int[] findErrorNums1(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int dup = -1, missing = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                missing = i;
            } else if (arr[i] == 2) {
                dup = i;
            }
        }
        return new int[]{dup, missing};
    }

    /**
     * Created by "gepeng" on 2020-05-24 20:34:53.
     * @Description 数组中假设有两个6 那么第一次将第6个元素取负数 第二次取为正数 ，而其他元素只出现一次，所以其他元素都是负数
     *               没有出现过的那个数，也是正数
     * @param [nums]
     * @return int[]
     */
    public int[] findErrorNums2(int[] nums) {
        int dup = -1, missing = 1;
        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0)
                // 负的，表明之前被别的数扫到过，那这又扫到了，表明出现两次了
            {
                dup = Math.abs(n);
            } else {
                nums[Math.abs(n) - 1] *= -1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }


}
