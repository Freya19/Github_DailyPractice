package freya19.practice.剑指offer;

/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
 */
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
