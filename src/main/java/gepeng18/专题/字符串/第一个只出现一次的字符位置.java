package gepeng18.专题.字符串;

import java.util.BitSet;

public class 第一个只出现一次的字符位置 {
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        //出现1次
        BitSet bs1 = new BitSet(256);
        //出现1次以上
        BitSet bs2 = new BitSet(256);

        for (char c : str.toCharArray()) {
            // 一次都没出现过，则记录出现1次
            if (!bs1.get(c))
                bs1.set(c);
            // 出现过一次，则记录到出现1次以上中，!bs2.get(c)为了不重复，不加也可
            else if (bs1.get(c) && !bs2.get(c))
                // 将索引处的值设为true 1 0  -> 1 1
                bs2.set(c);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 0 1
            if (bs1.get(c) && !bs2.get(c))
                return i;
        }
        return -1;
    }
}
