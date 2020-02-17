package gepeng18.sword2offer;

public class 机器人的运动范围 {
    int nums = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        countingSteps(threshold, rows, cols, 0, 0, visited);
        return nums;
    }

    public void countingSteps(int limit, int rows, int cols, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c] || bitSum(r) + bitSum(c) > limit) return ;
        visited[r][c] = true;
        nums += 1;
        countingSteps(limit, rows, cols, r - 1, c, visited);
        countingSteps(limit, rows, cols, r, c - 1, visited);
        countingSteps(limit, rows, cols, r + 1, c, visited);
        countingSteps(limit, rows, cols, r, c + 1, visited);

    }

    public int bitSum(int t) {
        int count = 0;
        while (t != 0) {
            count += t % 10;
            t /= 10;
        }
        return count;
    }
}
