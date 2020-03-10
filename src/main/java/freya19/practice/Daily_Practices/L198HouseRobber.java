package freya19.practice.Daily_Practices;

import java.util.Arrays;

public class L198HouseRobber {
    public int rob(int[] nums){
        int n = nums.length;
        if(n==0) return 0;

        int[] memo = new int[n];
        Arrays.fill(memo,-1);

        memo[n-1]=nums[n-1];
        for(int i = n-2;i>=0;i--)
            for(int j=i;j<n;j++)
                memo[i]=Math.max(memo[i],nums[j]+(j+2<n?memo[j+2]:0));
        return memo[0];
    }
}
