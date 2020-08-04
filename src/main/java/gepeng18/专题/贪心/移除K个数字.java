package gepeng18.专题.贪心;

import java.util.ArrayList;
import java.util.LinkedList;

public class 移除K个数字 {
    String removeKdigits(String num, int k) {
        LinkedList<Integer> s = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num.length(); i++){
            int number = num.charAt(i) - '0';
            while(s.size() != 0 && s.get(s.size()-1) > number && k > 0){
                s.pollLast();
                k--;
            }
            // 当数字不为0时或者为0，但是不空时，则可以加进去，否则都不加进去
            if (number != 0 || s.size() != 0){
                s.addLast(number);
            }
        }
        // 当k减到0时弹出来
        while(s.size() != 0 && k > 0){
            s.pollLast();
            k--;
        }
        for (int i = 0; i < s.size(); i++){
            result.append(s.get(i));
        }
        if (result.toString().equals("")){
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        移除K个数字 instance = new 移除K个数字();
        String result = instance.removeKdigits("1432219", 3);
        System.out.println(String.format("%s\n", result));
        String result2 = instance.removeKdigits("100200", 1);
        System.out.printf( String.format("%s\n", result2));
    }
}
