package gepeng18.专题.大数;

import java.util.Arrays;

public class SuperInteger {
    int[] digits;
    boolean returnNull;

    public int[] plusOne() {
        int carry = 0;

        //1. 先直接加1，然后进位
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        if (digits[digits.length - 1] > 9) {
            carry = 1;
            digits[digits.length - 1] = 0;
        }

        //2. 有进位，则不断进位
        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] > 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                carry = 0;
                break;
            }
        }

        //3. 全部进位后，如果还有进位,则return null
        if (carry == 1 && returnNull)
            return null;

        //4. 全部进位后，如果还有进位，则创建一个新的数组，首位置1即可
        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        } else
            return digits;
    }

    public void printNumbers(int n) {
        int[] num = new int[n];
        Arrays.fill(num,0);
        digits = num;
        returnNull = true;
        while (true) {
            int[] ints1 = plusOne();
            if (ints1==null) break;
            System.out.println(Arrays.toString(ints1));
        }
    }

    public static void main(String[] args) {
        new SuperInteger().printNumbers(3);
    }
}
