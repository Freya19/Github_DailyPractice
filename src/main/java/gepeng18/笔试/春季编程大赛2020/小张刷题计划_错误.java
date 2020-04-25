package gepeng18.笔试.春季编程大赛2020;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
 * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
 * 示例 1：
 * 输入：time = [1,2,3,3], m = 2
 * 输出：3
 * 解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
 * 示例 2：
 * 输入：time = [999,999,999], m = 4
 * 输出：0
 * 解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。
 * 限制：
 * 1 <= time.length <= 10^5
 * 1 <= time[i] <= 10000
 * 1 <= m <= 1000
 */

/**
 * 错误
 */
public class 小张刷题计划_错误 {
    class Element{
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int minTime(int[] time, int m) {
        if(time.length<=m)
            return 0;
        List<Element> list = new ArrayList<>();
        for(int i=0;i<time.length;i++){
            list.add(new Element(time[i],i));
        }
        List<Element> sorted = list.stream().sorted((e1, e2) -> {
            return e1.value - e2.value;
        }).collect(Collectors.toList());

        int[] hash = new int[time.length];
        int count = 0;
        for(Element e:sorted){
            if(count==time.length-m)
                break;
            hash[e.index] = 1;
            count++;
        }

        int [] result = new int[time.length-m];

        int resultIndex = 0;
        for(int i=0;i<hash.length;i++)
            if(hash[i]==1)
                result[resultIndex++] = time[i];


         return  split(result, 0, result.length - 1, m);
    }

    public static int split(int[] arr, int start, int end, int k) {
        if (k == 1) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }
            return sum;
        }
        if ((end - start + 1) == k) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (arr[i] > max) {
                    max = arr[i];

                }
            }
            return max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end + 1 - k; i++) {
            int sum = 0;
            for (int j = start; j <= i; j++) {
                sum += arr[j];
            }
            int larger = sum > split(arr, i + 1, end, k - 1) ? sum : split(arr, i + 1, end, k - 1);
            if (larger < min) {
                min = larger;

            }
        }
        return min;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.print(new 小张刷题计划_错误().minTime(arr, 2));
    }
}
