package gepeng18.专题.排序;

import java.util.Arrays;

/**
 * 讯飞官方
 */
public class QuickSort {


    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
        System.out.println(Arrays.toString(arr));
        return low;
    }


    private static void sort(int [] array,int start,int end){
        if (start>=end)
            return;
        int mid = partition(array, start, end);
        sort(array,start,mid-1);
        sort(array,mid+1,end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{25 ,84 ,21, 47, 15, 27 ,68, 35, 20};
        sort(array,0,array.length-1);
    }

}
