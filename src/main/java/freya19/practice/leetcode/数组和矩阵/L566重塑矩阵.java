package freya19.practice.leetcode.数组和矩阵;

public class L566重塑矩阵 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] reshapeNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapeNums[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return reshapeNums;
    }
}
