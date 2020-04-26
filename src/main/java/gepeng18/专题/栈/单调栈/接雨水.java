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
 * 本题栈中元素维护从大到小，因为当大的来后，小的要清算，所以要弹出，所以栈里放的都是最大的
 */
public class 接雨水 {
    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }


}
