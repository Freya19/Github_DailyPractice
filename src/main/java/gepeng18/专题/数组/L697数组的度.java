package gepeng18.专题.数组;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 */
public class L697数组的度 {

    class Int {
        int count = 0;
        int left = 0;
        int right = 0;

    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Int> map = new HashMap<>();
        if (nums.length != 0)
            for (int i = 0; i < nums.length; i++) {

                Int current = map.get(nums[i]);
                if (current == null) {
                    current = new Int();
                    current.left = i;
                }
                current.count = current.count + 1;
                current.right = i;
                map.put(nums[i], current);
            }


        Integer max = Collections.max(map.values().stream().map(i -> {
            return i.count;
        }).collect(Collectors.toList()));

        int minLength = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Int> entry : map.entrySet()) {
            if (entry.getValue().count == max) {
                minLength = Math.min(entry.getValue().right - entry.getValue().left + 1,minLength);
            }

        }

        return minLength;
    }

    public static void main(String[] args) {
        final int shortestSubArray = new L697数组的度().findShortestSubArray(new int[]{1, 2, 2, 3, 1});
        System.out.println(shortestSubArray);
    }
}
