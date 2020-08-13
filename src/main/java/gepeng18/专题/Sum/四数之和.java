package gepeng18.专题.Sum;

import gepeng18.practice.idea.sort;

import java.util.*;

public class 四数之和 {
    List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4)
            return res;
        int a,b,c,d,size=nums.length;
        for(a=0;a<=size-4;a++){
            if(a>0&&nums[a]==nums[a-1])
                continue;      //确保nums[a] 改变了
            for(b=a+1;b<=size-3;b++){
                if(b>a+1&&nums[b]==nums[b-1])
                    continue;   //确保nums[b] 改变了
                c=b+1;
                d=size-1;
                while(c<d){
                    if(nums[a]+nums[b]+nums[c]+nums[d]<target)
                        c++;
                    else if(nums[a]+nums[b]+nums[c]+nums[d]>target)
                        d--;
                    else{
                        res.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        c++;
                        d--;
                        while(c<d&&nums[c-1]==nums[c])      //确保nums[c] 改变了
                            c++;
                        while(c<d&&nums[d+1]==nums[d])      //确保nums[d] 改变了
                            d--;
                    }
                }
            }
        }
        return res;
    }
}
