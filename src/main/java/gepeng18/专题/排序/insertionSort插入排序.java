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
            for (j = i-1; j >= 0 ; j--) {
                // j 是否需要向后移动呢，如果需要移动，则后移，否则退出
                // 退出表明j+1右移了，j不用右移，所以j+1就是我们需要放置的位置
                if( arr[j]>temp )
                    arr[j+1]=arr[j];
                else
                    break;
            }
            //最终找到了这个待安放的值要出入的位置了
            arr[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8};
        int n = arr.length;
        insertionSort插入排序 is = new insertionSort插入排序();
        is.insertionSort(arr, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
