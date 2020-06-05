package gepeng18.专题.数组;

import java.util.ArrayList;

/**
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }
 * 且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 *
 */

public class L565嵌套数组 {
    /**
     * 将访问过的数标位-1，访问到-1直接跳出。原理是如果访问到之前一个循环中访问过的数，则说明也进入了之前的循环，没有必要再进行下去。
     */
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                // 标记该位置已经被访问
                nums[j] = -1;
                j = t;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
