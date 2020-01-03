package gepeng18.practice.idea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SortTestHelper {

    // SortTestHelper不允许产生任何实例
    private SortTestHelper() {
    }

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

        return;
    }
}


public class sort {
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static void SelectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[index]) {
                    index = j;
                }
            }
            swap(list, index, i);
        }
    }

    private static void InsertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int value = list[i];
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    list[j] = list[j - 1];
                } else {
                    break;
                }
                list[j] = value;
            }
        }
    }

    private static void MergeSort(int[] array) {
        MergeSort(array, 0, array.length - 1);
    }

    private static void MergeSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        MergeSort(array, left, mid);
        MergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] copyArray = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            copyArray[i - left] = array[i];
        }

        int mainIndex = left;
        int index1 = left;
        int index2 = mid+1;
        while(index1<=mid && index2 <= right){
            if(copyArray[index1-left]< copyArray[index2-left]){
                array[mainIndex] = copyArray[index1-left];
                index1++;
            }else{
                array[mainIndex] = copyArray[index2-left];
                index2++;
            }
            mainIndex++;
        }

        while(index1<=mid){
            int value = copyArray[index1-left];
            array[mainIndex] = value;
            mainIndex++;
            index1++;
        }
        while(index2<=right){
            int value = copyArray[index2-left];
            array[mainIndex] = value;
            mainIndex++;
            index2++;
        }


//        int i = left, j = mid+1;
//        for( int k = left ; k <= right; k ++ ){
//
//            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
//                array[k] = copyArray[j-left]; j ++;
//            }
//            else if( j > right ){   // 如果右半部分元素已经全部处理完毕
//                array[k] = copyArray[i-left]; i ++;
//            }
//            else if( copyArray[i-left]<copyArray[j-left]){  // 左半部分所指元素 < 右半部分所指元素
//                array[k] = copyArray[i-left]; i ++;
//            }
//            else{  // 左半部分所指元素 >= 右半部分所指元素
//                array[k] = copyArray[j-left]; j ++;
//            }
//        }

    }

    public static void main(String[] args) {
        int[] data = {7, 3, 8, 2, 6, 8, 0, 3, 6, 7, 8, 2, 3};
        int[] array1 = Arrays.copyOf(data, data.length);
        sort.SelectionSort(array1);
        SortTestHelper.printArray(array1);

        int[] array2 = Arrays.copyOf(data, data.length);
        sort.SelectionSort(array2);
        SortTestHelper.printArray(array2);

        int[] array3 = Arrays.copyOf(data, data.length);
        sort.MergeSort(array3);
        SortTestHelper.printArray(array3);

    }


}
