package gepeng18.专题.排序相关的题;

public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] nums) {
        int N = nums.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(nums[j]) && !isEven(nums[j + 1])) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
