package freya19.practice.笔试.XC;

import java.util.ArrayList;
import java.util.Scanner;

public class 最大收入 {

    int maxIncome = -1;
    int[][] incomes;

    public void getMaxIncome(int a, int b, int income, int p) {
        if (a == 0 && b == 0) {
            maxIncome = Math.max(maxIncome, income);
            return;
        }

        if (a > 0) {
            for (int i = p; i < incomes.length; i++) {
                getMaxIncome(a - 1, b, income + incomes[i][0], i + 1);
            }
        }

        if (b > 0) {
            for (int j = p; j < incomes.length; j++) {
                getMaxIncome(a, b - 1, income + incomes[j][1], j + 1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();
            a.add(incomeOfA);
            b.add(incomeOfB);
            //Start coding -- Input Data
        }

        //Start coding

        int[][] moneys = new int[a.size()][2];
        for (int i = 0; i < moneys.length; i++) {
            moneys[i][0] = a.get(i);
            moneys[i][1] = b.get(i);
        }

        最大收入 m = new 最大收入();
        m.incomes = moneys;
        m.getMaxIncome(moneys.length / 2, moneys.length / 2, 0, 0);
        System.out.println(m.maxIncome);
    }
}
