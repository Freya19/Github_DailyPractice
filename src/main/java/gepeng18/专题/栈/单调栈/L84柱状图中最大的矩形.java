package gepeng18.专题.栈.单调栈;

import java.util.Stack;

/**
 * 可以先看一下：https://blog.csdn.net/Zolewit/article/details/88863970
 * 找左边最近的比他小的  右边最近的比他小的
 */
public class L84柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }
}

