package gepeng18.专题.字符串;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 对角线打印 {
    /**
     * 左上角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayTopRight(int[][] array){
        int row = array.length;
        int col = array[0].length;

        //右上角，我们可以认为先从n - 1 到 0 列
        for (int k = col - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (int i = 0 ,j = k; j<col && i < row   ; i++,j++){
                System.out.print(array[i][j]+" ");
            }
        }

        //再从1 到 n - 1 行
        for (int k = 1 ; k <= row - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (int i = k ,j = 0; i < row   ; i++,j++){
                System.out.print(array[i][j]+" ");
            }
        }
    }

    /**
     * 左上角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayTopLeft(int[][] array){
        int row = array.length;
        int col = array[0].length;

        //右上角，我们可以认为先从n - 1 到 0 列
        for (int k = 0;k<col; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (int i = 0 ,j = k; i < row && j >= 0 ; i++,j--){
                System.out.print(array[i][j]+" ");
            }
        }

        //再从1 到 n - 1 行
        for (int k = 1 ; k <= row - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (int i = k ,j = col-1; i < row   ; i++,j--){
                System.out.print(array[i][j]+" ");
            }
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {
//                {0, 1, 2, 3,  4},
//                {5, 6, 7, 8,  9},
//                {10,11,12,13, 14}
//        };
//        printTwoDimensionalArrayTopRight(arr);
        int x[] = new int[4];
        System.out.println(Arrays.toString(x));


    }
}
