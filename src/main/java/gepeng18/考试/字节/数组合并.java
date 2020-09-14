package gepeng18.考试.字节;

import java.util.Arrays;

public class 数组合并 {
    // 归并排序的思路
    public static int[] merge1(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (index1 == arr1.length) {
                res[i] = arr2[index2];
                index2++;
            } else if (index2 == arr2.length) {
                res[i] = arr1[index1];
                index1++;
            } else if (arr1[index1] > arr2[index2]) {
                res[i] = arr2[index2];
                index2++;
            } else if (arr1[index1] < arr2[index2]) {
                res[i] = arr1[index1];
                index1++;
            }
        }
        return res;
    }

    // 链表合并的思路
    public static int[] merge2(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int resIndex = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] > arr2[index2]) {
                res[resIndex] = arr2[index2];
                index2++;
                resIndex++;
            } else if (arr1[index1] < arr2[index2]) {
                res[resIndex] = arr1[index1];
                index1++;
                resIndex++;
            }
        }

        // arr1结束了，那就把arr2的数字全部复制过来吧
        if (index1 == arr1.length) {
            for (int i = index2; i < arr2.length; i++) {
                res[resIndex] = arr2[i];
                resIndex++;
            }
        } else {
            for (int i = index1; i < arr2.length; i++) {
                res[resIndex] = arr1[i];
                resIndex++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res1 = merge1(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        int[] res2 = merge2(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }


}
