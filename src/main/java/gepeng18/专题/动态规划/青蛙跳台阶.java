package gepeng18.专题.动态规划;

import java.util.Arrays;

public class 青蛙跳台阶 {
    int[] nums ;

    public int jump(int n){
        nums = new int[n+1];
        Arrays.fill(nums,-1);
        return solution(n);
    }

    public int solution(int n) {

        if(n == 1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        if(nums[n] == -1)
            nums[n] = solution(n-2)+solution(n-1);
        return nums[n];

    }


    public static void main(String[] args) {
        System.out.println(new 青蛙跳台阶().jump(20));
    }

}
