package gepeng18.test;

import java.util.ArrayList;
import java.util.Scanner;

class 零钱 {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount+1];

        return findWay(coins,amount,0);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins,int amount,int start){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount] != 0){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int i = start;i < coins.length;i++){
            int res = findWay(coins,amount-coins[i],start+1);
            if(res >= 0 && res < min){
                min = res + 1;
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];
    }

    public static void main(String[] args) {
        int coin[] = new int[]{1,5,10,50,100};
        int nums[] = new int[]{5,2,2,3,5};
        ArrayList<Integer> input = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
        for(int i=0;i<5;i++)
            for( int j=0;j<nums[i];j++){
                input.add(coin[i]);
            }
        int [] newInput = new int[input.size()];
        for (int i=0;i<input.size();i++)
            newInput[i] = input.get(i);

        int i = new 零钱().coinChange(newInput, 55);
        System.out.println(i);
    }
}
