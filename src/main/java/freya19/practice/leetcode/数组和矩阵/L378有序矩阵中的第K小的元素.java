package freya19.practice.leetcode.数组和矩阵;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,   返回 13
 */

public class L378有序矩阵中的第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };

        //自定义cmp，则 传入2,3,4 -------> 出队的是4,3,2  ---（大顶堆）
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,cmp);
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pq.add(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int res = new L378有序矩阵中的第K小的元素().kthSmallest(matrix, 8);
        System.out.println(res);
    }
}
