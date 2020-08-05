package gepeng18.专题.二分查找.林沐.二分查找;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class 二分查找递归 {
    static boolean binary_search(int [] sort_array,
                       int begin, int end, int target){
        if (begin > end){
            return false;
        }
        int mid = (begin + end) / 2;
        if (target == sort_array[mid]){
            return true;
        }
        else if (target < sort_array[mid]){
            return binary_search(sort_array, begin, mid-1, target);
        }
        else if (target > sort_array[mid]){
            return binary_search(sort_array, mid + 1, end, target);
        }
        else
            throw  new RuntimeException("不可能倒这");
    }

    static ArrayList<Boolean> search_array(int [] sort_array, int [] random_array){
        ArrayList<Boolean> result = new ArrayList<>();
        for (int i = 0; i < random_array.length; i++){
            boolean res = binary_search(sort_array,
                    0,
                    sort_array.length - 1,
                    random_array[i]);
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
        int sort_array[] = {-1, 2, 5, 20, 90, 100, 207, 800};
        int random_array[] = {50, 90, 3, -1, 207, 80};
        ArrayList<Boolean> res = search_array(sort_array, random_array);
        System.out.println(res);
    }

}
