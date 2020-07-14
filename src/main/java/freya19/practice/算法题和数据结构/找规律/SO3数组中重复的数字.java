package freya19.practice.算法题和数据结构.找规律;


/**太诡异*/
public class SO3数组中重复的数字 {

    int res;

    public int findRepeatNumber(int[] nums) {
        res =-1;
        if(nums==null||nums.length==0){
            return res;
        }

        return res;
    }

    private boolean isRepeatNum(int[] nums, int length) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    res=nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
