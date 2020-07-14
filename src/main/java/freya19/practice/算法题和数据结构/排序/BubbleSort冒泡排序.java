package freya19.practice.算法题和数据结构.排序;

/**
 * 冒泡排序
 * 算法复杂度：
 */
public class BubbleSort冒泡排序 {
    public void bubbleSort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }

        //前 length-1-i 个元素比较，大的元素往后放
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
