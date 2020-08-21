package gepeng18.笔试.阿里巴巴2021;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 错误： 应该用回溯  1 2 3 - 1 3 3  -  1 3 1 2 33
 */
public class 数组一致 {
    public static boolean sovle(int[] a, int[] b, int [] c) {
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        while (indexA < a.length || indexB < b.length) {
            if (indexA == a.length) {
                if (b[indexB] == c[indexC++])
                    indexB++;
                else
                    return  false;
            } else if (indexB == b.length) {
                if (b[indexA] == c[indexC++])
                    indexA++;
                else
                    return false;
            }else if(a[indexA] == c[indexC]){
                indexC++;
                indexA++;
            }else if(b[indexB] == c[indexC]){
                indexB++;
                indexC++;
            }else
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        for (int i = 0;i<times;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int j = 0;j<n;j++)
                a[j] = in.nextInt();
            int[] b = new int[m];
            for (int j = 0;j<m;j++)
                b[j] = in.nextInt();
            int[] c = new int[m+n];
            for (int j = 0;j<m+n;j++)
                c[j] = in.nextInt();
            if (数组一致.sovle(a, b, c))
                System.out.println("possible");
            else
                System.out.println("not possible");

        }

    }
}
