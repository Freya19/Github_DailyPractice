package freya19.practice.面试题;

import java.util.ArrayList;
import java.util.List;

/*
你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，
长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
返回的长度需要从小到大排列。

示例：
输入：shorter = 1，longer = 2，k = 3
输出： {3,4,5,6}

提示：
    0 < shorter <= longer
    0 <= k <= 100000
 */
public class L1611跳水板 {
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] res = new int[k + 1];
//        List<Integer> res = new ArrayList<>();
        int len = 0;

        if (k == 0) {
            res[0] = 0;
            return res;
        }

        if (shorter == longer) {
            len = shorter * k;
            res[0] = len;
            return res;
        } else {
            for (int i = 0; i <= k; i++) {
                len = shorter * (k - i) + longer * i;
                res[i] = len;
            }
        }
        return res;
    }

    //输入1,1.与其结果是[0]。但实际结果是[]；
    public static void main(String[] args) {
        int longer = 2, shorter = 1, k = 3;

        L1611跳水板 l1611 = new L1611跳水板();
        int[] res = l1611.divingBoard(shorter, longer, k);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
