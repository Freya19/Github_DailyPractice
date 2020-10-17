package freya19.practice.笔试;

import java.util.Scanner;

public class 异或 {
    public int solve(int n){
        int sum = 0;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=n;j++) {
                sum^=(i%j);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] arr = new int[length];
        for (int i = 0;i<length;i++)
            arr[i] = input.nextInt();
        int sum = 0;
        for (int i = 0;i<length;i++)
            sum^=arr[i];
        int res = new 异或().solve(length);
        System.out.println(sum^res);
    }
}
