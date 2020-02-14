package gepeng18.leetcode;

import sun.security.util.Length;

import java.util.Arrays;

public class 两数之和_输入有序数组L167 {

    public static void main(String[] args) {
        final int i = Arrays.binarySearch(new int[]{2, 7, 11,15}, 1, 4, 7);
        System.out.println(i);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i=0;
        while(i<numbers.length){
            //判断[i+1,length-1]有没有target- [i]
            //有，则直接返回
            //没有，则i+1继续判断
            int findIndex = i==numbers.length-1?-1:Arrays.binarySearch(numbers,i+1,numbers.length,target-numbers[i]);
            if (findIndex>=0){
                return new int[]{i+1,findIndex+1};
            }else{
                i++;
            }
        }
        throw new IllegalArgumentException("未发现结果");
    }
}
