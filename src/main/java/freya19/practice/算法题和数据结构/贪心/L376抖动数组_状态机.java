package freya19.practice.算法题和数据结构.贪心;

import java.util.List;

public class L376抖动数组_状态机 {
    int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;

        int STATUS = BEGIN;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            switch (STATUS) {
                case BEGIN:
                    if (nums[i-1] < nums[i]) {
                        STATUS = UP;
                        maxLength++;
                    } else if (nums[i - 1] > nums[i]) {
                        STATUS = DOWN;
                        maxLength++;
                    }
                    break;
                case UP:
                    if (nums[i - 1] > nums[i]){
                        STATUS = DOWN;
                        maxLength++;
                    }
                    break;
                case DOWN:
                    if (nums[i - 1]  <  nums[i] ) {
                        STATUS = UP;
                        maxLength++;
                    }
                    break;
            }
        }
        return maxLength;
    }
}
