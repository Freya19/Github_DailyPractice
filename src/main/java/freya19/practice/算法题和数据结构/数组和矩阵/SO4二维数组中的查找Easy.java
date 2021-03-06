package freya19.practice.算法题和数据结构.数组和矩阵;

public class SO4二维数组中的查找Easy {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            int cmpVal = matrix[row][col];

            if (target == cmpVal) {
                return true;
            } else if (target < cmpVal) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        boolean ifExt = new SO4二维数组中的查找Easy().findNumberIn2DArray(matrix, 5);
        System.out.println(ifExt);
    }
}
