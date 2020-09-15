package freya19.practice.笔试.gld;

import java.util.Scanner;

public class 背包问题_愉悦度和耗电量 {


    private float[][] memo;

    // c:耗电量 ； v ：愉悦度 ; cap : 剩余电量
    public float like(float[] w, int[] val, int cap) {
        if (w == null || val == null || w.length != val.length) {
            throw new IllegalArgumentException("Invalid w or val !");
        }

        if (cap < 0) {
            throw new IllegalArgumentException("cap cannot be 0!");
        }

        int n = w.length;
        if (n == 0 || cap == 0) {
            return 0;
        }

        memo = new float[n][cap + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= cap; j++) {
                memo[i][j] = -1;
            }
        }
        return greastedLike(w, val, n - 1, cap);
    }

    private float greastedLike(float[] w, int[] val, int index, int cap) {
        if (cap <= 0 || index < 0) {
            return 0;
        }

        if (memo[index][cap] != -1) {
            return memo[index][cap];
        }

        float res = greastedLike(w, val, index - 1, cap);
        if (cap >= w[index]) {
            res = Math.max(res, val[index] + greastedLike(w, val, index - 1, cap - (int) w[index]));
        }

        memo[index][cap] = res;
        return memo[index][cap];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cc = in.nextInt();

        float[] c = new float[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextFloat();
            w[i] = in.nextInt();
        }
        float like = new 背包问题_愉悦度和耗电量().like(c, w, cc);
        System.out.println(like);
    }
}

