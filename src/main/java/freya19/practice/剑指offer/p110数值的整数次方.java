package freya19.practice.剑指offer;

public class p110数值的整数次方 {
    boolean invalidInput = false;

    public double Power(double base, int exponent) {
        //全局变量判断输入的值是否有效，false为有效
        invalidInput = false;
        double res = 0;
        //底数为0 ，指数为负数时，是无效的，直接返回0
        if (base == 0 && exponent < 0) {
            invalidInput = true;
            return res;
        }

        //指数小于0时，先对底数求幂次方，再将结果取倒数
        if (exponent < 0) {
            int absExponent = -exponent;
            double powerResult = powerWithExponent(base, absExponent);
            res = 1 / powerResult;
            return res;
        }

        //底数不为0，指数大于0，就直接求次方
        res = powerWithExponent(base, exponent);
        return res;
    }

    /**
     * 核心函数，这里有点像动态规划a^n可以分成很多个子次幂求解
     */
    private double powerWithExponent(double b, int e) {
        if (e == 0) {
            return 1;
        }
        if (e == 1) {
            return b;
        }

        //一般的情况下，直接递归调用，e>>1表示e除以2
        double ret = powerWithExponent(b, e/2);
        ret *= ret;
        //指数是奇数的情况，递归后还要乘以一次底数
        if (e % 2 == 1) {
            ret *= b;
        }

        //偶数的话，就直接返回递归后的结果即可
        return ret;
    }
}
