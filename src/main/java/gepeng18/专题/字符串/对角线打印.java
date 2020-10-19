package gepeng18.专题.字符串;

public class 对角线打印 {
    /**
     * 左上角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayTopRight(int[][] array){
        int n = array.length;
        int maxSize = n * n;
        int len = (maxSize + "").length();

        //初始角标
        int i = 0;
        int j = 0;

        //右上角，我们可以认为先从n - 1 到 0 列
        for (int k = n - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = 0 ,j = k; j <= n - 1 ; i++,j++){
                System.out.print(array[i][j]+" ");
            }
        }

        //再从1 到 n - 1 行
        for (int k = 1 ; k <= n - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = k ,j = 0; i <= n - 1  ; i++,j++){
                System.out.print(array[i][j]+" ");
            }
        }
    }

    /**
     * 左上角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayTopLeft(int[][] array){
        int n = array.length;

        //右上角，我们可以认为先从n - 1 到 0 列
        for (int k = 0;k<n; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (int i = 0 ,j = k; j>=0 ; i++,j--){
                System.out.print(array[i][j]+" ");
            }
        }

        //再从1 到 n - 1 行
        for (int k = 1 ; k <= n - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (int i = k ,j = n-1; i<n  ; i++,j--){
                System.out.print(array[i][j]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11},
                {12,13,14,15}
        };
        printTwoDimensionalArrayTopLeft(arr);
    }
}
