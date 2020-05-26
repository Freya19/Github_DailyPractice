package freya19.practice.剑指offer;

/**
 * A.BeC
 */
public class p127表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }

        //A部分（整数部分），可能是+和-
        scanInt(str);

        //.后面的小数部分（B），只能是+
        scanUnsignedInt(str);

        //e后面指数部分（C），可能是+和-
        scanInt(str);
        return false;
    }

    //核心函数

    /**
     * 1.扫描无符号整数
     */

    boolean scanUnsignedInt(char[] s1) {
        return false;
    }


    /**
     * 2.扫描有符号整数
     *
     * @param s2
     * @return
     */
    boolean scanInt(char[] s2) {
        return false;
    }
}
