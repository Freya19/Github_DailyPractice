package freya19.practice.LeetCode.栈;

import java.util.Stack;

/**
 * 数组中元素与下一个比它大的元素之间的距离
 * 给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是               [1,  1,  4,  2,  1,  1,  0,  0]。
 */

public class L739每日温度 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null && T.length < 2) {
            return null;
        }

        int[] res = new int[T.length];
        int left = 0, right = 1;
        while (right < T.length) {
            if (T[left] < T[right]) {
                res[left] = right - left;
                left++;
                right = left + 1;
            } else {
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        //           [1,  1,  4,  2,  1,  1,  0,  0]。

        int[] nums = {2, 1, 1, 3, 1, 2, 4, 5};
        //            3, 2, 1, 1, 1, 1, 1, 0
        int[] ints = new L739每日温度().dailyTemperatures(nums);
        for (int i : ints) {
            System.out.println(i);
        }

    }

}

/*Stack<Integer> in = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        int[] ret = new int[T.length-1];

        for(int t:T){
            in.push(t);
        }

        int currentElement = in.pop();
        int cnt =0;
        while (!in.isEmpty()){
            if(currentElement>in.peek()){
                helper.push(in.pop());
                cnt++;
            }else {
                return cnt;
            }
        }*/