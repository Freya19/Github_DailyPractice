package freya19.practice.题目分组.排序;
/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1：输入: nums = [1,1,1,2,2,3], k = 2      输出: [1,2]
 * <p>
 * 示例 2：输入: nums = [1], k = 1        输出: [1]
 * <p>
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */

import java.util.*;

public class L347前K个出现频率最高的元素 {
    public int[] topKFrequent(int[] nums, int k) {
        //nums中元素存放到map中，key为元素，value为元素出现次数
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (Integer num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        //获取map的entrySet，然后判断是否将其放入优先队列里
        Set<Map.Entry<Integer, Integer>> countsEntrySet = counts.entrySet();

        //自定义比较器。注意：存入优先队列的是map中的Entry，而优先队列中排序的是其value（也就是频次）
        Comparator<Map.Entry<Integer, Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        //创建优先队列，其中k是初始化容量，cmp就是刚刚自定义的比较器
        PriorityQueue<Map.Entry<Integer, Integer>> kFreq = new PriorityQueue<>(k, cmp);

        //接下来是判断map中的entry哪些可以入队，哪些不能入队
        for(Map.Entry<Integer, Integer> entry:countsEntrySet){
            kFreq.add(entry);
            if(kFreq.size()>k){
                kFreq.poll();
            }
        }

        //将队列中的值取出
        List<Integer> tmp = new ArrayList<>();
        while(!kFreq.isEmpty()){
            tmp.add(kFreq.poll().getKey());
        }

        //此时是反过来的，需要翻转
        Collections.reverse(tmp);

        //最后放到int[]中
        int[] res = new int[k];
        int m=0;
        for(Integer i:tmp){
            res[m++]=i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        L347前K个出现频率最高的元素 l347 = new L347前K个出现频率最高的元素();
        int[] ret = l347.topKFrequent(nums, k);
        for (Integer i : ret) {
            System.out.println(i);
        }

    }

    /**
     * 官方题解（但是返回值类型提交的时候是不可以改成List的）
     * @param args
     *
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

//        Set<Map.Entry<Integer, Integer>> entries = count.entrySet();
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            entry.getKey()；
//        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
        }
        Collections.reverse(top_k);
        return top_k;
    }
     */
}
