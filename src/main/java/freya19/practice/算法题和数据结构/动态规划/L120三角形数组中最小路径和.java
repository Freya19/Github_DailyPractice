package freya19.practice.算法题和数据结构.动态规划;

import javafx.util.Pair;

import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L120三角形数组中最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int triangleLength = triangle.size();
        int[][] dp = new int[triangleLength][triangleLength];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // 自底向上 ，故：
        // 1. 给 dp 最后一行赋值
        for (int j = 0; j < triangleLength; j++) {
            dp[triangleLength - 1][j] = triangle.get(triangleLength - 1).get(j);
        }

        // 2. 任意 i j 处(可以看出从倒数第二行开始往上） -----> 0,0处
        for (int i = triangleLength - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // j = 0, 1, 2, 3x    -----> j+1 = 1,2,3,4x    ---> dp：0, 1, 2, 3
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        // 3. 最终最优解在0 0 处
        return dp[0][0];
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3,4));
        lists.add(Arrays.asList(6,5,7));
        lists.add(Arrays.asList(4,1,8,3));

        int res = new L120三角形数组中最小路径和().minimumTotal(lists);
        System.out.println(res);
    }
}
