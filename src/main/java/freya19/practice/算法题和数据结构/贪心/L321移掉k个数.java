package freya19.practice.算法题和数据结构.贪心;

import java.util.LinkedList;
import java.util.Stack;

public class L321移掉k个数 {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> cmp = new LinkedList<>();
        // addFirst 头插 就是往队首的位置放置元素
        // 1. 初始化
        cmp.addFirst(num.charAt(0) - '0');

        // 2. 如果要新的元素比记录的元素小，移除记录的元素
        for (int i = 1; i < num.length(); i++) {
            int number = num.charAt(i) - '0';
            while (!cmp.isEmpty() && number < cmp.peekLast() && k > 0) {
                cmp.pollLast();
                k--;
            }

            // 直到 cmp为空 或者 记录的元素比要加入的元素小  或者 k减完了  则要将元素加入cmp中了
            // 不过有俩条件： （如果cmp为空的话，插入0就没有意义了）
            // 数字不为0（即使cmp为空） 或 cmp不为空（则0 也可以插入）
            if (!cmp.isEmpty() || number != 0) {
                cmp.addLast(number);
            }
        }

        // 上述代码循环操作结束 cmp非空 且 k没有减完
        // （递增的数据，上面的循环直接加入cmp中，现在要移除直到 k=0）
        while (!cmp.isEmpty() && k > 0) {
            cmp.pollLast();
            k--;
        }

        // 将结果转换成字符串
        StringBuilder res = new StringBuilder();
        int len = cmp.size();
        for (int i = 0; i < len; i++) {
//            res.append(cmp.get(i));
            res.append(cmp.pollFirst());
        }

        if(res.toString().equals("")){
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String retv = new L321移掉k个数().removeKdigits("1432219", 3);
        System.out.println(retv);
    }
}
