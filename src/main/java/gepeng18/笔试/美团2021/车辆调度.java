package gepeng18.笔试.美团2021;

public class 车辆调度 {
    int maxProfit = -1;
    int[][] profits;

    public static void main(String[] args) {
        车辆调度 solver = new 车辆调度();
        solver.profits = new int[][]{{10,20},{20,40}};
        solver.solve(1,1,0,0);
        System.out.println(solver.maxProfit);
    }

    // 还剩a,b那么多的选择
    public void solve(int left_a, int left_b, int profit, int cur) {
        if (left_a == 0 && left_b == 0) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }
        if (left_a > 0)
            for (int i = cur; i < profits.length; i++)
                solve(left_a - 1, left_b, profit + profits[i][0], i + 1);
        if (left_b > 0)
            for (int i = cur; i < profits.length; i++)
                solve(left_a, left_b - 1, profit + profits[i][1], i + 1);

    }
}
