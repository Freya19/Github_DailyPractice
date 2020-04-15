package gepeng18.专题.回溯;

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 */
public class L306累加数 {
    private boolean res = false;
    // q 已经判断多少个数了
    void back(String num,int num1,int num2,int q,int deep){
        if(deep>=3&&num.length() == q)
        {
            res = true;
            return;
        }
        for(int i=q;i<num.length();){
            if(num.substring(q,i+1).length()>1&&num.charAt(q)=='0')
                return;
            Integer tmpNum = null;
            try {
                tmpNum = Integer.valueOf(num.substring(q, i + 1));

            }catch (NumberFormatException e){
                return;
            }
            if(deep<2||num1+num2==tmpNum)
                back(num,num2,tmpNum,i+1,deep+1);
            if(res || num1!=0 && num1+num2<tmpNum)
                return;
            i++;
        }
    }

    public boolean isAdditiveNumber(String num) {
        if(num.length()<3)
            return false;
        back(num,0,0,0,0);
        return res;
    }

    public static void main(String[] args) {
        final boolean additiveNumber = new L306累加数().isAdditiveNumber("121474836472147483648");
        System.out.println(additiveNumber);
    }

}
