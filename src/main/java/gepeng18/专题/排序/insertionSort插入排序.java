package gepeng18.专题.排序;

/**
 * 可以想象成打牌的时候 把牌从小到大排列
 * 对于近乎有序的数据（比如一套系统的日志），插入排序甚至比 nlogn 的排序算法更快
 */

public class insertionSort插入排序 {
    // 赋值操作实现
    public void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            //将要比较的元素用一个临时变量保存一下
            int temp = arr[i];
            int j;
            for (j = i; j > 0 ; j--) {
                if( arr[j - 1]>temp )
                    arr[j]=arr[j-1];
                else
                    break;
            }
            //最终找到了这个待安放的值要出入的位置了
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 2, 3, 1, 5, 7, 4};
        int n = arr.length;
        insertionSort插入排序 is = new insertionSort插入排序();
        is.insertionSort(arr, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
