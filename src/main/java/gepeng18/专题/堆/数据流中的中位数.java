package gepeng18.专题.堆;

import javax.print.DocFlavor;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到左半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比右半边元素小，
             * 因此需要先将元素插入右半边，然后利用右半边为小顶堆的特点，取出堆顶元素即为最小元素，此时插入左半边 */
            right.add(val);
            left.add(right.poll());
        } else {
            left.add(val);
            right.add(left.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) left.peek();
    }
}
