package gepeng18.sword2offer;

public class 二维数组中的查找p44 {
    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j=array.length-1;
        while(i<array.length&&j>=0){
            //判断target与 [i][j]想比较
            if(target == array[i][j])
                return true;
            else if(target>array[i][j]){
                i++;
            }else
                j--;
        }
        return false;
    }

}