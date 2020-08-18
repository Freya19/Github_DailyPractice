package gepeng18.笔试.用友;

/**
 * 上下反转二维数组
 * 比如
 * {[1,2,3],[4,5,6] ,[7,8,9]}
 * 反转后为{[7,8,9],[4,5,6],[1,2,3]}
 */
public class 翻转二维数组 {
    public void solve(int [][] input){
        // 1 2 3
        // 4 5 6
        // 7 8 9
        int index = 0;
        int[][] res = new int[input.length][input[0].length];
        for (int i = input.length-1;i>=0;i--){
            for (int j = 0;j< input[0].length;i++)
                res[i][j] = input[index++][j];
        }
    }
}
