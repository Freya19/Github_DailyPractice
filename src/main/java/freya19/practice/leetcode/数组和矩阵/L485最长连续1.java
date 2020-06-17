package freya19.practice.leetcode.数组和矩阵;

/**
 * [1,1,0,1,1,1] --------3
 */

public class L485最长连续1 {
    public int findMaxConsecutiveOnes1(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int index = 0, cnt = 0, maxCnt = 0, len = nums.length;
        while (index < len) {
            if (nums[index] == 1) {
                cnt++;
                index++;
            } else if (nums[index] == 0) {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 0;
                index++;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);

        return maxCnt;
    }


    /**
     * 妙哇哇
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,1,0,0,0,0,1,1,1,1,0,1};
        int res = new L485最长连续1().findMaxConsecutiveOnes1(arr);
        System.out.println(res);
    }
}
