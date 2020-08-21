package gepeng18.专题.栈.单调栈;

import javax.swing.*;
import java.util.Stack;

public class 标准结构 {
    // 数字对比
    int [] nextGreaterElement(int [] nums) {
        int [] ans = new int[nums.length]; // 存放答案的数组
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) { // 倒着往栈里放
            while (!s.empty() && s.peek() <= nums[i]) { // 如果里面的人个子矮于刚来的大哥
                s.pop(); // 矮个起开，反正也被挡着了。。。
            }
            ans[i] = s.empty() ? -1 : s.peek(); // 这个元素身后的第一个高个
            s.push(nums[i]); // 进队，接受之后的身高判定吧！
        }
        return ans;
    }

    int [] dailyTemperatures(int [] T) {
        int [] ans = new int[T.length];
        Stack<Integer> s = new Stack<>(); // 这里放元素索引，而不是元素
        for (int i = T.length - 1; i >= 0; i--) {
            while (!s.empty() && T[s.peek()] <= T[i]) {  // 比对是比值
                s.pop();
            }
            ans[i] = s.empty() ? 0 : (s.peek() - i); // 得到索引间距
            s.push(i); // 加入索引，而不是元素
        }
        return ans;
    }
}
