package gepeng18.专题.大数;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */

/**
 * 这里返回值是int[] 表明用int来接收 表明n不会越界，所以也没必要这样写，就普通循环即可
 */

public class 打印从1到最大的n位数 {
    int[] digits;
    boolean returnNull;
    ArrayList<Integer> res = new ArrayList<>();

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

        // 这里的目的是有的题是越界返回空，有的是越界创建新数组，将其合二为一，此题较为简单，直接返回null即可
        //3. 如果最终还有进位,并且允许returnNull，则return null
        if (carry == 1 && returnNull)
            return null;
        else if (carry == 1 && !returnNull) {
            //4. 如果还有进位，不允许返回空，则创建一个新的数组，首位置1即可
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        } else
            return digits;



    }

    public int[] printNumbers(int n) {
        int[] num = new int[n];
        Arrays.fill(num,0);
        digits = num;
        returnNull = true;
        while (true) {
            int[] ints1 = plusOne();
            // 因为越界返回null，所以返回null就不用继续了
            if (ints1==null) break;
            int oneNum = 0;
            for(int i=0;i<ints1.length;i++){
                oneNum = oneNum*10+ints1[i];
            }
            res.add(oneNum);
        }

        int[] d = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            d[i] = res.get(i);
        }
        return d;
    }

    public static void main(String[] args) {
        new 打印从1到最大的n位数().printNumbers(3);
    }
}
