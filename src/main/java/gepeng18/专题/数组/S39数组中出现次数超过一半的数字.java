package gepeng18.专题.数组;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
 */
public class S39数组中出现次数超过一半的数字 {
    class Solution {
        public int majorityElement(int[] nums) {
            int x = 0, votes = 0;
            for(int num : nums){
                if(votes == 0) x = num;
                votes += num == x ? 1 : -1;
            }
            return x;
        }
    }

}
