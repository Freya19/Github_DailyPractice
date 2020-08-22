package gepeng18.专题.栈.单调栈;

import java.util.Stack;

/**
 * 可以先看一下：https://blog.csdn.net/Zolewit/article/details/88863970
 *
 * 栈中存的都是非严格单增的
 *
 * 加入是 1 2 2 1  则第二个2计算的值不是最大的  第一个2计算的是最大的
 *
 * 找左边最近的比他小的  右边最近的比他小的，这样两者相减，就是长方形的宽，高度就是本段的高
 * 而左边最近的比他小的就是栈中的上一个元素  右边最近的比他小的 就是当前元素（因为大的直接扔进去，小的才弹出来计算值，所以计算值时肯定遇到小的了）
 *
 * 然而如果栈中最后一直没有来比他小的呢，那之前的都计算不了，所以我们给数组加个0，让之前的元素必须弹出来
 *
 */
public class L84柱状图中最大的矩形 {
    public static int largestRectangleArea(int[] heights) {
        int[] newArr = new int[heights.length + 1];
        for (int i = 0;i<heights.length;i++)
            newArr[i] = heights[i];
        newArr[heights.length] = 0;
        Stack<Integer> stack = new Stack<>();

        int maxarea = 0;
        for (int i = 0; i < newArr.length; i++) {
            while (!stack.empty() && newArr[stack.peek()] >newArr[i]){
                Integer index = stack.pop();
                // 为空，表明左边没有比他矮的
                if(stack.isEmpty())
                    maxarea = Math.max(maxarea, newArr[index] * i);
                else
                    // 每一个柱子的长方形取决于栈中它之前的柱子和现在的柱子
                    maxarea = Math.max(maxarea, newArr[index] * (i - stack.peek() -1 ));

            }
            stack.push(i);
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int res = L84柱状图中最大的矩形.largestRectangleArea(new int[]{1,1});
        System.out.println(res);
    }
}

