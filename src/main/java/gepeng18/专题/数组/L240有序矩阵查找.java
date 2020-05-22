package gepeng18.专题.数组;

public class L240有序矩阵查找 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //找右上角的元素，target比这个数大，则一定在下面,比这个数小，则在左边
        if (matrix.length<=0||matrix[0].length<=0)
            return false;
        int i= 0;
        int j =matrix[0].length-1 ;
        while (i<matrix.length&&j>=0){
            if(target==matrix[i][j])
                return true;
            else if (target>matrix[i][j])
                i++;
            else
                j--;
        }
        return false;
    }
}
