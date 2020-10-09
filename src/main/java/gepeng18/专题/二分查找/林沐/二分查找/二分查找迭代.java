package gepeng18.专题.二分查找.林沐.二分查找;

import java.io.FilterOutputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class 二分查找迭代 {
    static boolean binary_search(int [] sort_array, int target){
        int begin = 0;
        int end = sort_array.length - 1;
        while(begin <= end){
            int mid = (begin + end) / 2;
            if (target == sort_array[mid]){
                return true;
            }
            else if (target < sort_array[mid]){
                end = mid - 1;
            }
            else if (target > sort_array[mid]){
                begin = mid + 1;
            }
        }
        return false;
    }

    static ArrayList<Boolean> search_array(int [] sort_array, int [] random_array){
        ArrayList<Boolean> result = new ArrayList<>();
        for (int i = 0; i < random_array.length; i++){
            boolean res = binary_search(sort_array, random_array[i]);
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
//        int [] arr = new  int[]{};
//        int sort_array[] = {-1, 2, 5, 20, 90, 100, 207, 800};
//        int random_array[] = {50, 90, 3, -1, 207, 80};
//        ArrayList<Boolean> res = search_array(sort_array, random_array);
//        System.out.println(res);
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println(i == j);
    }
}
