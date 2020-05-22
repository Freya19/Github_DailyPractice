package gepeng18.专题.数组;

public class L485找出数组中最长的连续 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                max = Math.max(max,count);
            }else
                count = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        final int res = new L485找出数组中最长的连续().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(res);
    }
}
