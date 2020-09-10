package freya19.practice.笔试;

import java.util.Arrays;

/**sougou - 1，玩具兑换礼物*/
public class 数组_用玩具兑换礼物 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能交换奖品的最大数量
     *
     * @param a int整型
     * @param b int整型
     * @param c int整型
     * @return int整型
     */
    int sum = 0;

    public void doNumOfPrize(int[] nums) {
        while (true) {
            int minimum = Math.min(nums[0], Math.min(nums[1], nums[2]));

            if (minimum < 0) {
                break;
            }
            sum += minimum;
            nums[2] -= minimum;
            nums[1] -= minimum;
            nums[0] -= minimum;

            Arrays.sort(nums);
            if (nums[2] <= 0) {
                break;
            }
            if (nums[2] == nums[1]) {
                nums[2] = nums[2] - 1;
                nums[1] = nums[1] - 1;
            } else {
                nums[2] = nums[2] - 2;
            }
            nums[0] = nums[0] + 1;
        }

    }

    public int numberofprize(int a, int b, int c) {
        // write code here
        doNumOfPrize(new int[]{a, b, c});
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}

