package gepeng18.leetcode.old;

public class L64最小路径和 {

    int [][] min;

    void init(int m, int n){
        min = new int[m][n];
        for(int i=0;i<m;i++){
            for( int j=0;j<n;j++){
                min[i][j] = -1;
            }
        }

    }
    public int compute(int [][] grid){
        int m= grid.length;
        int n = grid[0].length;
        init(m,n);

        for(int i=1;i<m;i++){
            min[i][0] += min[i-1][0];
        }

        for(int i=1;i<n;i++){
            min[0][i] += min[0][i-1];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++)
                min[i][j] = Math.min(min[i-1][j],min[i][j-1])+grid[i][j];
        }
        return min[m-1][n-1];
    }


    public int minPathSum(int[][] grid) {

        return compute(grid);
    }
}
