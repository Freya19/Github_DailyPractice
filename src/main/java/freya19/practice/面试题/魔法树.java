package freya19.practice.面试题;

import java.util.Arrays;
import java.util.Scanner;

public class 魔法树 {
    public int solver(int [] num){
        Arrays.sort(num);
        int min = num[0];
        int sum = 0;
        for (int i= 1 ;i<num.length;i++){
            sum +=num[i]-min;
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numsLength = input.nextInt();
        if(numsLength==0)
            System.out.println(0);
        int[] array = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            array[i] = input.nextInt();
        }
        int res = new 魔法树().solver(array);
        System.out.println(res);
    }
}



