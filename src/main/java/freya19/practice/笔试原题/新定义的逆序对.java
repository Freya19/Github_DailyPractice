package freya19.practice.笔试原题;

import java.util.HashMap;

/**
 * 如果一个数的4倍正好是它的逆序数，即为逆序对
 * 不超过n的数中，有多少对逆序对
 */
public class 新定义的逆序对 {

    public static boolean find(int num){
        // 1001100 1100
        // 5 20 2
            // 如果一个数和他的四倍是逆序，则return true else return false
        int num4 = num * 4;
        String s = String.valueOf(Integer.valueOf(new StringBuilder(String.valueOf(num4)).reverse().toString()));
        if(s.equals(String.valueOf(num)))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int n = (int) Math.pow(10,7);
        for(int i=1;i<n;i++){
            // 我们现在只需要判断i是否是逆序
            if(find(i)){
                System.out.println(i+" "+4*i);
            }
        }
    }
}
