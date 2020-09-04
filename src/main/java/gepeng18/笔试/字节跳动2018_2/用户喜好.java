package gepeng18.笔试.字节跳动2018_2;

import java.util.Scanner;

/**
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 */
public class 用户喜好 {
    public int solve(int [] num,int l,int r,int target){
        int times = 0;
        // 在num中找 l-1和r-1中有几个数==target
        for (int i = l-1;i<=r-1;i++){
            if(num[i] == target)
                times++;
        }
        return times;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numLength = input.nextInt();
        int[] nums = new int[numLength];
        for (int i = 0; i < numLength; i++) {
            nums[i] = input.nextInt();
        }
        int times = input.nextInt();
        用户喜好 sovler = new 用户喜好();
        for (int i = 0; i < times; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            int target = input.nextInt();
            int res = sovler.solve(nums, l, r, target);
            System.out.println(res);
        }
    }
}
