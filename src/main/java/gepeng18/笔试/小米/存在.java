import java.util.Scanner;

public class 存在 {
    private final static int[][] nexts = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };
    private int rows;
    private int cols;

    public boolean solve(String[] paths, int rows, int cols, String dst) {
        if (rows == 0 || cols == 0)
            return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] flags = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (back(paths, dst, 0, flags, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean back(String[] paths, String dst, int length, boolean[][] flags, int r, int c) {
        if (dst.length() == length)
            return true;
        if (r < 0 || r > rows || c < 0 || c >= cols || Character.toLowerCase(paths[r].charAt(c)) != Character.toLowerCase(dst.charAt(length)) || flags[r][c])
            return false;
        flags[r][c] = true;
        for (int[] next : nexts) {
            if (back(paths, dst, length + 1, flags, r + next[0], c + next[1]))
                return true;

        }
        flags[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine().trim();
        if (s == null || s.length() == 0)
            System.out.println(false);
        System.out.println(new 存在().solve(new String[]{"ABCE", "SFCS", "ADEE"}, 3, 4, s));

    }

}
