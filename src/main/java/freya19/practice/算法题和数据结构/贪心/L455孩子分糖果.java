package freya19.practice.算法题和数据结构.贪心;

import java.util.Arrays;

public class L455孩子分糖果 {
    public int findContentChildren(int[] g, int[] s) {
        // g 小孩， s 糖果
        if (g == null || s == null) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                // 孩子得到糖果，就到下一个孩子
                child++;
            }
            // 无论当前孩子得不得到糖果，饼干都要往后移（得不到，表示饼干小了；得到，那就下一个饼干对应下一个孩子）
            cookie++;

        }
        // 有几个小朋友可以吃到糖果
        return child;
    }
}
