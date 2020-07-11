package freya19.practice.题目分组.数组和矩阵;

/**
 * 6′26″
 */

public class SO3数组中重复的数字Easy {
    public int findRepeatNumber(int[] nums) {

        int res=-1;
        if(nums==null||nums.length==0){
            return res;
        }

        int len = nums.length;
        int[] cnt = new int[len];
        for(int num:nums){
            cnt[num]++;
        }

        for(int i=0;i<cnt.length;i++){
            if(cnt[i]>1){
                res=i;
                break;
            }
        }
        return res;
    }
}
