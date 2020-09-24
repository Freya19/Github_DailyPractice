package gepeng18.笔试.K58;

import com.sun.jndi.cosnaming.CNCtx;

import java.util.Arrays;

public class 一的个数 {
    public static int[] countBits(int num){
      int [] ret = new int[num+1];
        for (int j = 0; j <= num; j++) {
            int i = j;
            int cnt = 0;
            while (i!=0){
                if (i%2==1){
                    cnt++;
                }
                i = i>>1;
            }
            ret[j] = cnt;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ints = countBits(2);
        System.out.println(Arrays.toString(ints));
    }
}
