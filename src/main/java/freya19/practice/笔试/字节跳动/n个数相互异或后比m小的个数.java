package freya19.practice.笔试.字节跳动;

import java.util.*;

public class n个数相互异或后比m小的个数 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        if (nums == null || nums.length == 0) {
            System.out.println(0);
        }

        int curNum = 0;
        int[] res = new int[n * (n - 1) / 2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                curNum = nums[i] ^ nums[j];
                res[i] = curNum;
            }
        }

        int cnt = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > m) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}