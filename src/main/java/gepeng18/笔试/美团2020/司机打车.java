package gepeng18.笔试.美团2020;

import java.util.*;

public class 司机打车 {
    private double curScore = 0.00;
    private double maxScore = -1000.00;//0.00只能过80%
    private ArrayList<Integer> add;
    // 其中Aij 代表订单i司机j匹配的分值
    public void Solution(double[][] nums) {
        int n = nums.length;
        int [] flag = new int[n];
        ArrayList<Integer> temp = new ArrayList<>();
        Best(flag,temp, nums, 0);
        System.out.println(String.format("%.2f", maxScore));
        for(int i = 0;i<add.size();i++) {
            System.out.println(i+1 +" "+ add.get(i));
        }
    }


    public void Best(int [] flag,ArrayList<Integer> curState, double[][] nums, int curLine)
    {
        //退出条件
        if(curLine==nums.length) {
            if(maxScore < curScore) {
                maxScore = curScore;
                add = (ArrayList<Integer>) curState.clone();
            }
            return ;
        }
        // 当前状态下，我还有哪些选择
        //轮流考虑当前row行，选取每一列的可能性
        for(int i = 0;i<nums.length;i++) {
            //该列未选取
            if(flag[i]!=1) {
                flag[i] = 1;
                curScore += nums[curLine][i];
                curState.add(i+1);
                Best(flag,curState, nums, curLine+1);

                curState.remove(curState.size()-1);
                curScore -= nums[curLine][i];
                flag[i] = 0;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            double[][] nums = new double[n][n];
            for(int i = 0;i<n;i++)
                for(int j = 0;j<n;j++)
                    nums[i][j] = in.nextDouble();
            司机打车 s = new 司机打车();
            s.Solution(nums);
        }
    }
}
