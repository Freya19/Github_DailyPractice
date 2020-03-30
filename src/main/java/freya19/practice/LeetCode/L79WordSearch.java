package freya19.practice.LeetCode;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成。
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 */
public class L79WordSearch {
    // 上下左右移动的偏移量
    private int[][] dest = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // 行 和 列
    private int m, n;
    // 标志位数组
    private boolean[][] used;

    // 元素是否越界
    private boolean inArea(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null && word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;  // 行
        if (m == 0)
            throw new IllegalArgumentException("board can not be empty.");
        n = board[0].length; // 列
        if (n == 0)
            throw new IllegalArgumentException("board can not be empty.");

        used = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (wordSearch(board, word, 0, i, j))
                    return true;

        return false;
    }

    // board是待搜索的二维数组；word是待查找的字符串，index是当前要查找的字母位置；
    // startx和starty是word[index]在board中所处位置的某一个元素的坐标
    private boolean wordSearch(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length()-1) {
            return board[startx][starty] == word.charAt(index);
        }

        if (board[startx][starty] == word.charAt(index)) {
            used[startx][starty] = true;// 占用当前元素
            for (int i = 0; i < 4; i++) {
                int newx = startx + dest[i][0];
                int newy = starty + dest[i][1];
                if (inArea(newx, newy) && !used[newx][newy]) {
                    if (wordSearch(board, word, index + 1, newx, newy))
                        return true;
                }
            }
            used[startx][starty] = false; // 解除占用，也就是当前这个元素的前后左右都么有找到
        }
        return false;
    }
}
