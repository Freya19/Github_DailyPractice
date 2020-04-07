package gepeng18.leetcode;

public class L48旋转图像 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        r(matrix, 0, len - 1, len -1);
    }
    public void r(int[][] matrix, int start, int end, int num) {
        if(start < end){
            for(int i = 0; i < num; i++){
                int tmp = matrix[start][start + i];
                matrix[start][start + i] = matrix[end- i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = tmp;
            }
            r(matrix, start + 1, end - 1, num - 2);
        }
    }
}
