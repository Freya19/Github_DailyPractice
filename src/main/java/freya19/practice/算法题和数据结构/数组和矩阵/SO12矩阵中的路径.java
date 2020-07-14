//package freya19.practice.题目分组.剑指offer;
//
///**
// * 1. 上下左右移动的走法 —— 一个二维数组{{-1,0}，{0，1},{1,0},{0,-1}}
// * 2. 标记是否走过 —— 一个数组 marked[r][c]=true/false
// * 3.
// */
//public class T12矩阵中的路径 {
//    /**
//     * 下一步走哪
//     */
//    int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//    int rows, cols;
//
//    //入口函数
//    public boolean exist(char[][] board, String word) {
//        this.rows = board.length;
//        this.cols = board[0].length;
//
//        boolean[][] marked = new boolean[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (hasPath(board, word, marked, 0, i, j)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean hasPath(char[][] board, String word, boolean[][] marked, int pathLen, int r, int c) {
//        if (word.length() == pathLen) {
//            return true;
//        }
//
//        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word.charAt(pathLen) || marked[r][c]) {
//            return false;
//        }
//
//
//    }
//}
