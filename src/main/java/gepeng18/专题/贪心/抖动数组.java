package gepeng18.专题.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 抖动数组 {
    int wiggleMaxLength(List<Integer> nums) {
        if (nums.size() < 2) {
            return nums.size();
        }
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;
        int STATE = BEGIN;
        int max_length = 1;
        for (int i = 1; i < nums.size(); i++) {
            switch (STATE) {
                case BEGIN:
                    if (nums.get(i - 1) < nums.get(i)) {
                        STATE = UP;
                        max_length++;
                    } else if (nums.get(i - 1) > nums.get(i)) {
                        STATE = DOWN;
                        max_length++;
                    }
                    break;
                case UP:
                    if (nums.get(i - 1) > nums.get(i)) {
                        STATE = DOWN;
                        max_length++;
                    }
                    break;
                case DOWN:
                    if (nums.get(i - 1) < nums.get(i)) {
                        STATE = UP;
                        max_length++;
                    }
                    break;
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(Arrays.asList(1,17,5,10,13,15,10,5,16,8));

        System.out.println(String.format("%d\n", new 抖动数组().wiggleMaxLength(nums)));
    }
}
