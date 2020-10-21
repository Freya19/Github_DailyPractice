package gepeng18.专题.排序相关的题;

import java.util.Arrays;

public class 面试题40_2 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);

        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void partitionArray(int[] arr, int low, int high, int k) {
        // 做一次 partition 操作
        int m = partition(arr, low, high);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArray(arr, low, m-1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            partitionArray(arr, m+1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int base = arr[low];
        int first = low;
        while (low < high) {
            while (low < high && arr[high] >= base)
                high--;
            while (low < high && arr[low] <= base)
                low++;
            if (low < high)
                swap(arr, low, high);
        }
        swap(arr, low, first);
        return low;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
