package freya19.practice.LeetCode.双指针;

/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

说明:
    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
 */
public class L88合并两个有序数组 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;

        int r1 = m - 1;
        int r2 = n - 1;
        int i = m + n - 1;

        while (r1 >= 0 && r2 >= 0)
            nums1[i--] = nums1[r1] > nums2[r2] ? nums1[r1--] : nums2[r2--];

        //将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2,0,nums1,0,r2+1);

    }

    //这个测试是不行的，LeetCode对nums1应该自动做了扩容的初始化操作，直接提交上面的代码是ok的
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 5, 6};
        int m = arr1.length;
        int n = arr2.length;

        L88合并两个有序数组 L88 = new L88合并两个有序数组();
        L88.merge(arr1, m, arr2, n);
        for (int arr : arr1)
            System.out.println(arr);
    }
}
