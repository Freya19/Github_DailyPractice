package gepeng18.专题.数组;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class L283MoveZeroes {
    public void moveZeroes1(int[] nums) {
        int[] newArray = new int[nums.length];
        int newIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                newArray[newIndex++] = nums[i];
        }

        for (int i=0;i<newArray.length;i++)
            nums[i] = newArray[i];
    }

    public void moveZeroes2(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new L283MoveZeroes().moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
