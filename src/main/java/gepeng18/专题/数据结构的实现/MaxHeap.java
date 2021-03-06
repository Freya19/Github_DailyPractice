package gepeng18.专题.数据结构的实现;
import java.lang.*;
import java.util.Collections;
import java.util.LinkedHashMap;


// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item) {

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取最大堆中的堆顶元素
    public Item getMax() {
        assert (count > 0);
        return data[1];
    }


    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //* 最大堆核心辅助函数
    private void shiftUp(int k) {

        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {

        while (2 * k <= count) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0)
                j++;

            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            if (data[k].compareTo(data[j]) >= 0) break;
            swap(k, j);
            k = j;
        }
    }

    // 测试 MaxHeap
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        // 堆中元素个数
        int N = 100;
        // 堆中元素取值范围[0, M)
        int M = 100;
        for (int i = 0; i < N; i++)
            maxHeap.insert(new Integer((int) (Math.random() * M)));

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++){
            assert arr[i - 1] >= arr[i];
        }

    }
}
