package gepeng18.专题.滑动窗口;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 */
public class L209长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0 , r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length){
            if(r + 1 < nums.length && sum < s){
                r++;
                sum += nums[++r];
            }
            else{
                sum -= nums[l++];
                l++;
            }

            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }

        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new L209长度最小的子数组().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
