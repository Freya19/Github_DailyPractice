package freya19.practice.排序;

/**
 * 可以想象成打牌的时候 把牌从小到大排列
 * 对于近乎有序的数据（比如一套系统的日志），插入排序甚至比nlogn的排序算法更快
 */

public class insertionSort插入排序 {
    //交换前后元素进行排序（耗时，性能低），因为交换表赋值要耗时
    public void insertionSort1(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = 0;
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    // 赋值操作实现
    public void insertionSort2(int[] arr, int n) {
        for (int i = 1; i < n; i++) {

            int temp = arr[i]; //将要比较的元素用一个临时变量保存一下
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j]=arr[j-1];
            }
            //最终找到了这个待安放的值要出入的位置了
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 2, 3, 1, 5, 7, 4};
        int n = arr.length;
        insertionSort插入排序 is = new insertionSort插入排序();
        is.insertionSort2(arr, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
