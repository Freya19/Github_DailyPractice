package freya19.practice.算法题和数据结构.双指针;

public class L633平方数之和 {
    public boolean judgeSquareSum(int c) {

        if (c < 0) {
            return false;
        }

        //j的开根号处理，妙啊
        int i = 0, j = (int) Math.sqrt(c), sum = 0;
        while (i < j) {
            sum = i * i + j * j;
            if (sum > c) {
                j--;
            } else if (sum < c) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
