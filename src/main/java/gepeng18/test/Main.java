package gepeng18.test;

import gepeng18.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class Solution {
 * public:
 *     int maxProfit(vector<int>& prices) {
 *         int beg=0;//买入点
 *         int end=0;//卖出点
 *         int pro=0;//利润初始化为0应付价格一直下跌
 *         int record=0;//记录当日卖出的最大利润
 *         for(end=0;end<prices.size();end++)
 *         {
 *              if(prices[beg]>prices[end])//遇到价格更低时直接重置买入价格
 *                 beg=end;
 *             int record=prices[end]-prices[beg];
 *             pro=record>pro?record:pro;
 *         }
 *         return pro;
 *     }
 * };
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int [] rec1 = new int[4];
        int [] rec2 = new int[4];
        for (int i=0;i<4;i++){
            rec1[i] = Integer.valueOf(strings[i]);
        }
        for (int i=4;i<8;i++){
            rec2[i-4] = Integer.valueOf(strings[i]);
        }
        boolean b = Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
        if(b)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
