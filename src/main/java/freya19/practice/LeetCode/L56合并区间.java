package freya19.practice.LeetCode;
/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]    输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:
输入: [[1,4],[4,5]]   输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间
。
 */

import java.util.*;

public class L56合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;

        //利用辅助的双向队列和单向队列
        Deque<int[]> deque = new LinkedList<>(); //将原数组存到这个双向队列里（记得双向入和取）
        Queue<int[]> queue = new LinkedList<>(); //将不需要再比较的数组放到这个队列里

        for (int[] arr : intervals) {
            deque.offerFirst(arr);
        }
        while (!deque.isEmpty() && deque.size() > 0) {
            if (deque.size() > 1) {
                int[] e1 = deque.removeLast();  //删除并得到末尾元素
                int[] e2 = deque.removeLast();  //删除并得到倒数第二个元素

                int[] tempArray = new int[]{e1[0],e1[1],e2[0],e2[1]}; //1,4,0,4
                Arrays.sort(tempArray); //0,1,4,4
                int len = tempArray.length;

                if(e1[0]<=e2[0]&&e1[1]>=e2[1]){
                    deque.add(new int[]{tempArray[0],tempArray[len-1]});

                }else if (e1[0]<e2[0]&&e1[1]<e2[1]) {
                    deque.offerLast(new int[]{e1[0],e2[1]});
                } else {
                    queue.offer(e1);
                    deque.addLast(e2);
                }
            } else {
                //对最后一个元素做处理
                int[] element = deque.removeLast();
                queue.add(element);
            }
        }
        int len = queue.size();
        int[][] res = new int[len][];
        for (int i = 0; i < len; i++) {
            res[i] = queue.remove();
        }

        return res;

    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {0, 4}, {8, 10}, {15, 18}};
        L56合并区间 l56 = new L56合并区间();

        int[][] retVal = l56.merge(intervals);

        for (int[] e : retVal) {
            for (int i : e) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

//        int[][] intervals= new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        System.out.println(intervals.length);
//        Deque<int[]> deque = new LinkedList<>(); //将原数组存到这个双向队列里（记得双向入和取）
//        for(int[] arr:intervals){
//            deque.offerFirst(arr);
//        }
//
//        int[] temp = deque.removeLast();
//        System.out.println(temp[0]);
//
//        for(int[]e:deque){
//            for(int i:e){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }

    }
}
