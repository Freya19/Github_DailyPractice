package gepeng18.笔试.讯飞笔试题;

import java.util.Arrays;

/**
 *  初始序列：        25 84 21 47 15 27 68 35 20
 *  第一轮： 以25为界
 */
public class 快排 {
    public static void main(String[] args) {
        int[] array = new int[]{25 ,84 ,21, 47, 15, 27 ,68, 35, 20};
        new 快排().sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    void sort(int [] array,int start,int end){
        if (start>=end)
            return;
        int mid = partition(array, start, end);
        sort(array,start,mid-1);
        sort(array,mid+1,end);
    }

    int partition(int [] array, int left, int right){
        System.out.print(left+"---"+right+" --- ");
        int base = array[left];
        int j = left;
        // [left j]: <0       [j+1 i) :>0
        for(int i=left+1;i<=right;i++){
            if(array[i]<base){
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,left,j);
        System.out.println(Arrays.toString(array));
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
