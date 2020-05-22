package gepeng18.专题.数组;

import java.util.Arrays;

public class L566改变矩阵维度 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r<0||c<0)
            return nums;
        if(nums.length==0)
            return nums;
        if(nums.length*nums[0].length!=r*c)
            return nums;

        int oldI = 0;
        int oldJ = 0;
        int[][] newArray = new int[r][c];
        for(int i=0;i<newArray.length;i++){
            for(int j=0;j<newArray[0].length;j++){
                newArray[i][j] = nums[oldI][oldJ];
                oldJ++;
                if(oldJ == nums[0].length){
                    oldI++;
                    oldJ = 0;
                }

            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        final int[][] res = new L566改变矩阵维度().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        for(int [] a:res)
            System.out.println(Arrays.toString(a));
    }
}
