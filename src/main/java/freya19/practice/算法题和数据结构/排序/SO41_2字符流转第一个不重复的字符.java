package freya19.practice.算法题和数据结构.排序;

import java.util.LinkedList;
import java.util.Queue;

public class SO41_2字符流转第一个不重复的字符 {
    int[] cnt = new int[256];
    Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnt[ch]++;
        queue.add(ch);

        while (!queue.isEmpty()&&cnt[queue.peek()]>1){
                queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty()?'#':queue.peek();
    }
}
