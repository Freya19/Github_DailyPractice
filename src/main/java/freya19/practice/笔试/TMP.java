package freya19.practice.笔试;

public class TMP {
    /**
     *
     * @param num int整型 非负整数 num
     * @return int整型一维数组
     */
    public int[] countBits (int num) {
        // write code here
        int[] ret = new int[num+1];

        for (int j = 0; j <= num; j++) {
            int i=j;
            int cnt = 0;
            while (i != 0) {
                if (i % 2 == 1) {
                    cnt++;
                }
                i = i >> 1;
            }
            ret[j] = cnt;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] re = new TMP().countBits(7);
        for (int i:re){
            System.out.print(i);
        }
    }
}