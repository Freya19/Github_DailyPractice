package gepeng18.专题.动态规划;

import java.util.Scanner;

public class 剪绳子 {

    int [] nums = new int[1000];

    public 剪绳子() {
        for(int i=0;i<1000;i++)
            nums[i] = -1;
    }

    // 将n进行分割(至少分成两部分)，可以获得的最大乘积
    public int cuttingRope(int target) {
        if(target ==1)
            return 1;

        if(nums[target]!=-1){
            return nums[target];
        }

        int max = -1;
        for(int i=1;i<target;i++){
            max = Math.max(i* cuttingRope(target-i),Math.max(max,i*(target-i)));
        }
        nums[target]=max;
        return nums[target];
    }

    public static void main(String[] args) {

        Scanner  scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
    }
}
