package freya19.practice.笔试.mi;

import java.util.Scanner;
/** liuyubobobo的回溯法 —— AC时出了比较大的问题（可能是我哪里写错了） */
public class 字符矩阵中匹配字符串 {

        // 上下移动
        int[][] moved = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        // 行 列 数
        int m, n;
        // 记录元素使用情况的标志位
        boolean[][] used;

        public boolean exist(char[][] matrix, String target) {

            if(matrix==null||target==null){
                throw new IllegalArgumentException("matrix or target is null!");
            }
            // 行
            m = matrix.length;
            if(m==0){
                throw new IllegalArgumentException("matrix is empty !");
            }
            // 列
            n = matrix[0].length;
            if(n==0){
                throw new IllegalArgumentException("matrix is empty !");
            }

            // 初始化元素使用情况的标志位
            used = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isExisted(matrix, target, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        // 寻找的过程中，用于判断移动时是否越界
        boolean inArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }

        // 查询元素
        boolean isExisted(char[][] martix, String target, int index, int startx, int starty) {
            if (index == target.length() - 1) {
                return martix[startx][starty] == target.charAt(index);
            }

            if (martix[startx][starty] == target.charAt(index)) {
                used[startx][starty] = true;
                for (int i = 0; i < 4; i++) {
                    int newx = startx + moved[i][0];
                    int newy = starty + moved[i][1];
                    if (inArea(newx, newy) && used[newx][newy] && isExisted(martix, target, index + 1, newx, newy)) {
                        return true;
                    }
                    used[startx][starty] = false;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine().trim();
            char[][] matrix = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
            boolean res = new 字符矩阵中匹配字符串().exist(matrix, s);
            System.out.println(res);

        }


}
