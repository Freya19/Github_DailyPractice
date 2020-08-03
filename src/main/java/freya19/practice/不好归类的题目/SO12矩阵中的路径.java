package freya19.practice.不好归类的题目;

import java.util.Arrays;

public class SO12矩阵中的路径 {

    private final static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        int rows = board.length,cols=board[0].length;
        boolean[][] used = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(findPath(board,word,used,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[][] matrix, String word, boolean[][] used, int pathLen, int r, int c) {
        if(word.length()==pathLen){
            return true;
        }

        if(r<0||r>=matrix.length||c<0||c>=matrix[0].length||matrix[r][c]==word.charAt(pathLen)||used[r][c]) {
            return false;
        }

        boolean[][] newUsed = matrixClone(used);
        newUsed[r][c]=true;
        for(int[] m:move ){
            if(findPath(matrix,word,newUsed,pathLen+1,r+m[0],c+m[1])){
                return true;
            }
        }
        return false;
    }

    private boolean[][] matrixClone(boolean[][] oldMatrix){
        boolean[][]  newMatrix = new boolean[oldMatrix.length][oldMatrix[0].length];
        for(int i=0;i<oldMatrix.length;i++){
            for(int j=0;j<oldMatrix[0].length;j++){
                newMatrix[i][j]=oldMatrix[i][j];
            }
        }
        return newMatrix;
    }

}
