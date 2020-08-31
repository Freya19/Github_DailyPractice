package freya19.practice.Java基础知识;

import java.util.Scanner;

public class 字符串变换 {
    public static String solve(String s,int [][] transfer){
        for (int i =0;i<transfer.length;i++){
            s = s.replaceAll("" + transfer[i][0], "" + transfer[i][1]);

        }
        return s;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int times = input.nextInt();
        int[][] tranfer = new int[times][2];
        for (int i =0;i<times;i++){
            tranfer[i][ 0 ] = input.nextInt();
            tranfer[i][ 1 ] = input.nextInt();
        }

        String res = solve(s, tranfer);
        System.out.println(res);
    }

}