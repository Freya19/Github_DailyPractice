package gepeng18.专题.二分查找.林沐.相关题目;

/**
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，系统都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，系统会告诉你这个数字比系统选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
 *
 * -1 : 系统选出的数字比你猜测的数字小
 *  1 : 系统选出的数字比你猜测的数字大
 *  0 : 恭喜！你猜对了！
 * 
 *
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 */
public class L374猜数字大小 {
    public int guessNumber(int n) {
        int begin = 1;
        int end = n;
        while (begin<=end){
            int mid = begin+(end-begin)/2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid)< 0)
                end = mid-1;
            else
                begin = mid+1;

        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
