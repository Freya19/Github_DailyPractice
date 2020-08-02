package gepeng18.笔试.讯飞笔试题;

import java.util.Scanner;

/**
 * 考虑特殊情况：
 * 1. 出现了数字，但是是全0，我们假设打印0
 * 2. 没出现数字，则打印空行
 */
public class 字符串转数字 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int negativeCnt = 0;
        boolean numAppear = false;
        StringBuilder nums = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numAppear = true;
                nums.append(s.charAt(i));
            } else if (s.charAt(i) == '-') {
                if (!numAppear)
                    negativeCnt++;
            }
        }

        // 万一前面一堆0，则不能打印00001 只能打印1
        int i = 0;
        for (; i < nums.toString().length(); i++) {
            if (nums.toString().charAt(i) != '0')
                break;
        }
        // 出现了数字，并且不是全0，则正常可以打印
        if (numAppear && i != nums.toString().length()) {
            if (negativeCnt % 2 == 1) System.out.print("-");
            System.out.println(nums.toString().substring(i));
        }else if(numAppear)
            // 出现了数字，并且是全0
            System.out.println(0);
        else
            // 数字都没出现
            System.out.println();
    }
}
