package freya19.practice.算法题和数据结构.数组和矩阵;

public class P01数组中比前面大比后面小的元素 {
    int res = 0;

    private int findTarget(int[] nums) {

        // times用来记录对于每一个 i ，满足条件的前后元素个数，最终如果等于元数据元素个数-1，表示就是这个i了；

        for (int i = 0; i < nums.length; i++) {

            int times = 0;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    times++;
                }
            }

            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] > nums[i]) {
                    times++;
                }
            }

            if (times == nums.length - 1) {
                res = nums[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 3, 5, 6};
        int index = new P01数组中比前面大比后面小的元素().findTarget(nums);
        System.out.println(index);

    }

}
