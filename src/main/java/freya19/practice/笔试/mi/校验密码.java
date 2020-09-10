package freya19.practice.笔试.mi;

import java.util.*;

public class 校验密码 {

    public static void check(String s) {
        boolean hasNum = false;
        boolean hasSymbol = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                // 含数字
                hasNum = true;
            } else if (Character.isLowerCase(s.charAt(i))) {
                // 含小写字母
                hasLowerCase = true;
            } else if (Character.isUpperCase(s.charAt(i))) {
                // 含大写字母
                hasUpperCase = true;
            } else {
                // 含字符
                hasSymbol = true;
            }
        }

        if (len < 8 || len > 120) {
            // 长度不符合返回 1
            System.out.println(1);
        } else if (hasNum && hasSymbol && hasLowerCase && hasUpperCase) {
            // 复合要求 返回 0
            System.out.println(0);
        } else {
            // 类型不符合 返回 2
            System.out.println(2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();

        String[] strs = s.split(" ");
        for (String str : strs) {
            check(str);
        }
    }
}
