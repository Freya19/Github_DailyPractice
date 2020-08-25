package freya19.practice.笔试.中兴;

import java.util.Scanner;

public class 区间平均数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int average = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] < average + 1) {
                    break;
                }
                temp = temp + nums[j];
                average = temp / (j - i + 1);
                if (average > max) {
                    max = average;
                }
            }
        }
        System.out.println(max);
    }
}

