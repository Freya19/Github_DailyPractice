package gepeng18.专题.排序.排序;

import java.util.*;

public class 自定义排序 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,2);
        map.put(1,1);
        map.put(2,0);
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        sort(list,0,list.size()-1);
        System.out.println(list);
    }

    public static void sort(List<Map.Entry<Integer, Integer>> src,int low, int high){
        if (low>=high)
            return ;
        int mid = partition(src, low, high);
        sort(src,low,mid-1);
        sort(src,mid+1,high);
    }
    public static int partition(List<Map.Entry<Integer, Integer>> src,int low, int high){
        Integer base =  src.get(low).getValue();
        Integer first = low;
        while (low<high){
            while (low<high&&src.get(high).getValue()>=base)
                high--;
            while (low<high&&src.get(low).getValue()<=base)
                low++;
            if (low<high)
                swap(src,low,high);
        }
        swap(src,first,low);
        return low;
    }

    public static void swap(List<Map.Entry<Integer, Integer>> src,int i, int j){
        Map.Entry<Integer, Integer> tmp = src.get(i);
        src.set(i,src.get(j));
        src.set(j,tmp);
    }

}
