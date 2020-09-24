package gepeng18.笔试.K58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class 公共数组 {
    public static List<Integer> solve(List<Integer> arrayA,List<Integer> arrayB){
        LinkedHashSet<Integer> listA = new LinkedHashSet<>(arrayA);
        LinkedHashSet<Integer> listB = new LinkedHashSet<>(arrayB);
        listA.retainAll(listB);
        return new ArrayList<>(listA);
    }

    public static void main(String[] args) {
        List<Integer> solve = solve(new ArrayList<>(Arrays.asList(-5, 0, 6, 8, 9, 10)), new ArrayList<>(Arrays.asList(0, 8, 9, 11, 15)));
        System.out.println(solve);
    }
}
