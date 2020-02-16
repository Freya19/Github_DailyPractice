package freya19.practice.SwordToOffer;

public class p44FindIn2DArray {
    public boolean Find(int target, int [][] array) {
        int i = 0; //第一行
        int j = array[0].length - 1; //最后一列
        while (i < array.length && i >= 0 && j >= 0) {
            if (target == array[i][j]) return true;
            else if (target > array[i][j]) i++;
            else j--;
        }
        return false;
        }

}
