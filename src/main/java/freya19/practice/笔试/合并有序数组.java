package freya19.practice.笔试;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class 合并有序数组 {
    /**
     * 合并数组
     * @param arrayA int整型ArrayList 数组A
     * @param arrayB int整型ArrayList 数组B
     * @return int整型ArrayList
     */
    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        LinkedHashSet<Integer> listA = new LinkedHashSet<>(arrayA);
        LinkedHashSet<Integer> listB = new LinkedHashSet<>(arrayB);
        listA.retainAll(listB);
        return new ArrayList<>(listA);
    }
}
