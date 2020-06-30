package gepeng18.专题.大数;

import java.util.Arrays;

public class L66加一 {
    public int[] plusOne(int[] digits) {

        int carry = 0;

        digits[digits.length-1] = digits[digits.length-1]+1;
        if(digits[digits.length-1]>9)
        {
            carry = 1;
            digits[digits.length-1] = 0;
        }

        for(int i=digits.length-2;i>=0;i--){
            digits[i] = digits[i]+carry;
            if(digits[i]>9){
                digits[i] = 0;
                carry = 1;
            }else
                carry = 0;
        }

        if(carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = new L66加一().plusOne(new int[]{9});
        System.out.println(Arrays.toString(ints));
    }
}
