package gepeng18.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class iterator {
    static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int slow = 0, fast = 1;
        //[0:slow]是不重复的，目前判断fast
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 长度为索引 + 1
        return slow+1;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 2, 2, 3, 4, 5, 6, 7});
    }
}
