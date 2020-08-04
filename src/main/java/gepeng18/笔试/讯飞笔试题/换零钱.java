package gepeng18.笔试.讯飞笔试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 纸币面值有1元、5元、10元、50元、100元几种。输入每种纸币的数量，再输入纸币总数，问是否能通过已有纸币组成总数，若能则输出所需的最少数量，若不能则输出-1.

 * 输入格式：
 * 第一行为5中纸币的数量，用空格隔开；
 * 第二行为纸币总数

 * 输出格式：
 * 一行，-1或者最少数量
 *
 * 样例输入：
 * 5 3 2 2 6
 * 55
 *
 * 样例输出
 * 2
 * 解释：55元，由50元+5元两张组成。
 */
public class 换零钱 {
    public static void main(String[] args) {
        int cnt = 0;
        Scanner input = new Scanner(System.in);
        int [] money = new int[]{1,5,10,50,100};
        int[] nums = new int[5];
        for (int i=0;i<5;i++)
            nums[i] = input.nextInt();
        int sum = input.nextInt();
        while (sum>0){
            // 钱数>=100，并且还有100元的可以换，那就直接换呗，换完后还有多少钱要换
            if(sum>=money[4]&&nums[4]>0)
                sum = sum- money[4];
            else if (sum>=money[3]&&nums[3]>0)
                sum = sum- money[3];
            else if (sum>=money[2]&&nums[2]>0)
                sum = sum- money[2];
            else if (sum>=money[1]&&nums[1]>0)
                sum = sum- money[1];
            else if (sum>=money[0]&&nums[0]>0)
                sum = sum- money[0];
            else{
                // 上面的条件是 sum>money[0]&&nums[0]>0 那么任意一个条件不满足，就来这了
                // 1. sum = 0,那也需要退出循环 2. 1块的钱都没了，那也要退出循环
               break;
            }
            // 前5种情况需要+1，而最后一种情况break了，所以这里cnt++完全可以
            cnt++;
        }
        System.out.println(cnt);

    }
}
