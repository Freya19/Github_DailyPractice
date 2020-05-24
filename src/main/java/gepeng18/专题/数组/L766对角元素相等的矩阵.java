package gepeng18.专题.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * <p>
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 */

public class L766对角元素相等的矩阵 {
    // 假设矩阵 3*4
    // [2 0]  [1,0  2,1] [0,0 1,1 2,2] [0,1 1,2 2,3] [0,2 1,3 ]
    public boolean isToeplitzMatrix(int[][] matrix) {
        // groups中存储每条对角线的第一个元素的值
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r - c))
                    groups.put(r - c, matrix[r][c]);
                else {
                    //和groups中的某个元素是在同一对角线上，则需要判断当前值和groups中对角线的值是否相等
                    if (groups.get(r - c) != matrix[r][c])
                        return false;
                }
            }
        }
        return true;

    }
}
