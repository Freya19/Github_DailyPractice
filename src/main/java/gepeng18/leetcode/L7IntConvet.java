package gepeng18.leetcode;

class IntConvetL7 {
    public static void main(String[] args) {
        int sum = 1000;
        int reverse = SolutionL7.reverse(sum);
        System.out.println(reverse);
    }
}


class SolutionL7 {
    public static int reverse(int x) {
        // 321
        int result = 0;
        int originalX = x;

        while (x != 0) {
            result = result * 10 + x % 10;  // 1    12   123
            x = x / 10;           // 32  3  0
        }

        //为了检测溢出，我们进行判断，如果y翻转后和x一样，则表明没有溢出
        int revertResult = 0;
        int originalResult = result;
        while (originalResult != 0) {
            revertResult = revertResult * 10 + originalResult % 10;  // 1    12   123
            originalResult = originalResult / 10;           // 32  3  0
        }

        if((revertResult == originalX) || (originalX % revertResult == 0))

            return result;
        else
            return 0;
    }
}

