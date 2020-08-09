package freya19.practice.算法题和数据结构.动态规划;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。*/

public class SO60n个骰子的点数 {
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // 一个骰子 6 个面
        final int face = 6;
        // n个骰子 n*6 个面（的点数）
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        // 初始化边界 （1 个骰子时）
        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }

        // 从两个骰子起
        for (int i = 2; i <= n; i++) {
            /* 使用 i 个骰子最小点数为 i */
            for (int j = i; j <= pointNum; j++){
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }

        return ret;
    }
}
