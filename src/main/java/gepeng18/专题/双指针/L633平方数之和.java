package gepeng18.专题.双指针;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L633平方数之和 {
    private final double distance = 0.00001;
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right =  (int) Math.sqrt(c);
        while(left<=right){
            if(Math.abs(Math.pow(left,2)+Math.pow(right,2)-c)<=distance)
                return true;
            else if(Math.pow(left,2)+Math.pow(right,2)<c)
                left++;
            else
                right--;
        }
        return false;
    }

    public static void main(String[] args) {
        final boolean b = new L633平方数之和().judgeSquareSum(4);
        System.out.println(b);
    }
}
