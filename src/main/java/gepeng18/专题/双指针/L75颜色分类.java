package gepeng18.专题.双指针;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 进阶：
 *
 *     一个直观的解决方案是使用计数排序的两趟扫描算法。
 *     首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 *     你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 */
public class L75颜色分类 {
    public static void sortColors(int[] nums) {
        final int[] res = new int[nums.length];
        final int[] cts = new int[3];
        for(int i=0;i<nums.length;i++){
            cts[nums[i]]++;
        }
        int index = 0;
        for(int ctIndex=0;ctIndex<cts.length;ctIndex++){
            for (int i = 0; i < cts[ctIndex]; i++) {
                res[index++] = ctIndex;
            }
        }
        for(int i=0;i<res.length;i++)
            nums[i] = res[i];
    }

    public static void main(String[] args)  {
        final int[] input = new int[]{0,1,2};
        final ArrayList<Integer> objects = new ArrayList<>(Arrays.asList(1,2,3));
        objects.remove(new Integer(2));
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
