package freya19.practice.剑指offer;

/**
 * 6′26″
 */

public class T3数组中重复的数字Easy {
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
