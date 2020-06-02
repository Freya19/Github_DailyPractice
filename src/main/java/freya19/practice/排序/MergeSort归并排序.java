package freya19.practice.排序;

/**
 * 归并排序
 * 关键点：
 * 1. 排序：分成两部分，对每个部分再进行归并排序（递归）
 * 2. 归并 （索引、越界、值的大小比较）
 */

public class MergeSort归并排序 {
    public void mergeSort(int[] arr, int n) { //n 依旧是数组的长度
        realizeMergeSort(arr, 0, n - 1);   //递归的函数
    }

    /**
     * 递归调用对arr[l...r]范围进行归并排序（闭区间，也可以用开区间）
     */
    public void realizeMergeSort(int[] arr, int l, int r) {
        //递归终止条件（越界停止）
        // 递归终止条件中，l>r会出现栈空间溢出的异常；包注意包含r
        if (l >= r)
            return;

        //实际上如果按计算式计算的话，有整型溢出的异常；但是排序可以先不管
        int mid = (l + r) / 2;
        //递归调用 对左边的部分进行排序
        realizeMergeSort(arr, l, mid);
        //递归调用 对右边的部分进行排序
        realizeMergeSort(arr, mid + 1, r);
        //排序完成后，进行归并，得到完整的排序号的数组
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r) {

        //首先要定义一个临时数组tempArr，并将arr[l...r]中的数据复制到其中
        int[] tempArr = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            //注意这里索引比较多，不要搞混。比如arr[i]不是arr[l]
            tempArr[i - l] = arr[i];
        }

        // 比较大小，将小的元素归并
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 前半部分越界
                arr[k] = tempArr[j - l];
                j++;
            } else if (j > r) {
                //后半部分越界
                arr[k] = tempArr[i - l];
                i++;
            } else if (tempArr[i - l] < tempArr[j - l]) {
                // 不越界了。值小的先归并
                arr[k] = tempArr[i - l];
                i++;
            } else {
                arr[k] = tempArr[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 2, 3, 1, 5, 7, 4};
        int n = arr.length;
        MergeSort归并排序 ms = new MergeSort归并排序();
        ms.mergeSort(arr, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
