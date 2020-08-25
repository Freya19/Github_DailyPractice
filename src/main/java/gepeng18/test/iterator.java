package gepeng18.test;

import java.util.*;

public class iterator {
    public static void main(String[] args) {
       int sum = 0;
        int n = 3;
       int bottom = 0;
       while(n>0 || bottom>2){
           // 消费
           sum += n;
           bottom += n;
           n = bottom/3;
           bottom -= n*3;
       }
        System.out.println(sum);
    }
}
