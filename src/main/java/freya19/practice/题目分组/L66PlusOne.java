package freya19.practice.题目分组;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class L66PlusOne {
    //    public int[] plusOne(int[] digits) {
//        for (int i = digits.length - 1; i >= 0; i--) {
//            if (digits[i] != 9) {
//                digits[i]++;
//                return digits;
//            }
//            digits[i] = 0;
//        }
//
//        //跳出for循环，说明数字全部是9
//        int[] temp = new int[digits.length + 1];
//        temp[0] = 1;
//        return temp;
//    }
    public int[] plusOne(int[] digits) {
        int carry = 0; // 进1 的标志位
        int len = digits.length;

        //判断最后一位
        if (digits[len - 1] < 9) {
            digits[len - 1] = digits[len - 1] + 1;
            carry = 0;
        } else if (digits[len - 1] == 9) {
            digits[len - 1] = 0;
            carry = 1;
        }

        //判断第一位到倒数第二位
        for (int i = len - 2; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + carry;
                carry = 0;
            } else if (digits[i] == 9 && carry != 1) {
                digits[i] = digits[i];
                carry = 0;
            } else if (digits[i] == 9 && carry == 1) {
                digits[i] = 0;
                carry = 1;
            }
        }
        if (carry == 0)
            return digits;

        int[] res = new int[len + 1];
        if (carry == 1) {
            res[0] = carry;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] a1 = {1, 9, 9};
//        int[] a2 = {0};
//        int[] a3 = {};
//        int[] a4 = {1,2,3,9};
//        int[] a5 = {9,9}; //输出要是[1,0,0]  为啥呢？？？？？ 因为99+1 = 100.。。。


        L66PlusOne po = new L66PlusOne();
        int[] nums = po.plusOne(a1);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
