package gepeng18.笔试.浦发;

import java.util.ArrayList;
import java.util.Scanner;

public class  丢手绢_滚出去 {
    // 1 2  4 5 6 7
    public static int solve(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            list.add(i);
        }
        int rmv = 0;
        int index = 0;
        while (list.size()!=1){
            if (rmv == 2) {
                // 需要删除，则将index处删了，并且计数器重置，而此时index指向被删除后面一个元素，正好是计时器的初始元素
                rmv = 0;
                list.remove(index);
            }else{
                // 不删除的时候，才向后移
                index = (index+1)%list.size();
                rmv++;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(solve(n));
    }
}
