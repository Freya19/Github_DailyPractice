package gepeng18.专题.排序;


public class MergeSort归并排序2 {

    public int[] sort(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return nums;
        }

        sort(nums, 0, len - 1);
        return nums;
    }

    /**
     * nums[left..right] 排序
     */
    private void sort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, left, mid, right);
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序，现在使left~right有序
     */
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right+1];
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] res = new MergeSort归并排序2().sort(new int[]{8, 5, 3, 5, 6, 8, 9, 1});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

