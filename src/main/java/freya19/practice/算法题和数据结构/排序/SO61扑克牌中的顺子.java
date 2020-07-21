package freya19.practice.算法题和数据结构.排序;

import java.util.Arrays;

public class SO61扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {

        if (nums.length < 5) {
            return false;
        }
        //O9(nlogn)
        Arrays.sort(nums);

        //O(n)  ----  找到0
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
        }

        //找数组中不连续的数之间需要消耗几个（-=）0，cnt个0够不够补
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }
}

/**
 * 找数组中不连续的数之间需要消耗几个（-=）0，cnt个0够不够补
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 0) {
                return false;
            } else if (nums[i + 1] - nums[i] > 1) {
                cnt -= nums[i + 1] - nums[i] - 1;
            } else {
                return true;   // 就是这个问题，如果找到了一个相邻连续的情况，就直接return掉了
            }
        }
 */