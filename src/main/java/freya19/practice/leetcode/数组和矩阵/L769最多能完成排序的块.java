package freya19.practice.leetcode.数组和矩阵;

public class L769最多能完成排序的块 {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int ret = 0;
        int tmpNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            tmpNum = Math.max(tmpNum, arr[i]);
            if (tmpNum == i) {
                ret++;
            }
        }
        return ret;
    }
}
