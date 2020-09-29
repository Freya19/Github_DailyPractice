package freya19.practice.面试;

public class 合并俩有序数组 {
    public int[] mergeTwoNums(int[] nums1, int[] nums2) {
        // 存放合并后的数组
        int len = nums1.length + nums2.length;
        int[] res = new int[len];

        // 指向两个数组初始位置的下标
        int p1 = 0, p2 = 0;
        // 指向res的下标
        int p = 0;

        // 遍历两个数组，比较当元素的大小，小的放到res中
        // 或的话会越界
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                res[p] = nums1[p1];
                p1++;
                p++;
            } else {
                res[p] = nums2[p2];
                p2++;
                p++;
            }
        }

        // 退出循环后，如果数组还有元素没有被安排上，继续安排
        if (p1 == nums1.length) {
            // nums1遍历完成，就把nums2剩下的元素赋值过来
            for (int i = p2; i < nums2.length; i++) {
                res[p] = nums2[i];
                p++;
            }
        } else {
            // nums2遍历完成，就把路nums1剩下的赋值过来
            for (int i = p1; i < nums1.length; i++) {
                res[p] = nums1[i];
                p++;
            }
        }
        return res;
    }
}
