package gepeng18.practice.idea;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/

import com.sun.media.sound.SoftTuning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionL1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            int remain = target - num;
            if (!map.containsKey(remain)) {
                map.put(num, index);
            } else {
                result[0] = index;
                result[1] = map.get(remain);
                break;
            }
        }
        return result;
    }
}

public class twoSumL1 {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = SolutionL1.twoSum(array, 9);
        System.out.println(Arrays.toString(result));
    }
}
