package gepeng18.专题.栈.单调栈;

import java.util.Stack;

/**
 * 推荐视频讲解：  https://leetcode-cn.com/problems/trapping-rain-water/solution/bilibilishi-mu-mu-xi-ya-4chong-guan-fang-jie-fa-zu/
 */

/**
 * 单调栈就两步：
 * 弹栈
 * 入栈
 *
 * 而弹栈涉及到 弹完后 计算
 *
 * 并且这道题是横向存水
 *
 * 栈中存的是递减的，当来了一个大的，那就表明之前比它小的都可以积水了，并且一定能积水，
 * 因为对于之前的一个数来说，之前的之前的数都比他大，目前的这个数也比他大，所以可以积水
 */
public class 接雨水 {
    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int current = 0; current < height.length; current++) {
            //如果栈不空并且 来了一个大值，那之前比它小的就可以存水啦
            while (!stack.empty() && height[stack.peek()] < height[current]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈,弹出之前的值
                if (stack.empty()) { // 栈空就表明栈中本来就一个值，来了一个大值，那之前也存不了水
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);  // peek为current之前的之前的值
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
        }
        return sum;
    }


}
