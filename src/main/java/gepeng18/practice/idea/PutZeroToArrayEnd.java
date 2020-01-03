package gepeng18.practice.idea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//将数组中所有的零都放到数组末尾
//难度 低
public class PutZeroToArrayEnd {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 5, 0, 6, 3, 8, 0));
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if ((Integer) list.get(right) == 0) {
                right--;
                continue;
            }
            if ((Integer) list.get(left) != 0) {
                left++;
                continue;
            }
            int temp = 0;
            temp = (Integer) list.get(right);
            list.set(right, list.get(left));
            list.set(left, temp);
        }
        System.out.println(list);
    }
}
