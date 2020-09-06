package freya19.practice.算法题和数据结构.二分查找;
/*
实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4   输出: 2

示例 2:
输入: 8   输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */

/**
 * 二分查找法
 * 存在整数a满足 a^2 ≤ x < (a+1)^2 ，称 a 为 x 的 整数平方根。
 */
public class L69实现平方根计算 {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int res = binarySearch(1, x, x);
        return res;
    }

    public int binarySearch(int left, long right, int nums) {
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid <= nums && (mid + 1) * (mid + 1) > nums) {
                return (int)mid;
            } else if (mid * mid > nums && (mid - 1) * (mid - 1) <= nums) {
                return (int)mid-1;
            }else if(mid*mid >nums){
                right=mid-1;
            }else{
                left = (int) mid + 1;
            }
        }
        return 0;
    }
}

//其中right如果是int类型的，提交上去会显示超出时间限制
//将right换成long类型的，相应的下面几个mid操作要强转为int类型，就可以通过。