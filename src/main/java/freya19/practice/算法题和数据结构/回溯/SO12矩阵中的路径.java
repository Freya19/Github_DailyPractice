package freya19.practice.算法题和数据结构.回溯;

public class SO12矩阵中的路径 {

    private int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int rows = board.length, cols = board[0].length;
        boolean[][] used = new boolean[rows][cols]; // 用来判断这个元素是否已经被使用过了

        // 对每个元素进行判断（一步一步走）
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findPath(board, word, used, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[][] matrix, String word, boolean[][] used, int pathLen, int r, int c) {
        // 如果当前在矩阵中找到的字符串的长度pathLength和要找的word长度相等，表示找到啦
        if (word.length() == pathLen) {
            return true;
        }

        // 如果这些条件中有一个不满足，表示找不到（最后一个条件有点疑惑）
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] != word.charAt(pathLen) || used[r][c]) {
            return false;
        }

        // 以上都不满足，表示传入的str还不是，并且可以移动找下一个字符
        // 1. 首先，当前元素置为以使用
        used[r][c] = true;
        // 2. 递归调用找下一个（上下左右四个方向都要找哦）
        for (int[] m : move) {
            if (findPath(matrix, word, used, pathLen + 1, r + m[0], c + m[1])) {
                return true;
            }
        }
        // 3. 如果[r][c]处往前推进但是没有找到，表示其周围4个元素都不在路径上，所以到回退，[r][c]置为未使用
        used[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean res = new SO12矩阵中的路径().exist(matrix, "ABCCED");
        System.out.println(res);
    }
}
