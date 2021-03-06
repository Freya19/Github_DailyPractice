/**
get到了：StringBuilder的妙处（可以append啊~）
get到了，这种关于字符串数组比较巧妙的判断操作（遍历 由内而外 ）
 */


package freya19.practice.算法题和数据结构.字符串;

public class L14MaxCommonPrefixSolution {
    public String maxCommonPrefix(String [] strs) {
        if (strs.length == 0) return " ";

        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minlength = Math.min(minlength, strs[i].length());
        }
        if (minlength == 0) return " ";

        char firstChar = strs[0].charAt(0);
        for (int i = 1; i < strs.length; i++) {
            //这个循环用于判断第i个位置的字符是否相同，相同的话，继续执行，
            //直到字符数组里所有的字符串都被遍历了，都相等，就从循环出来；否则，返回空字符串。
            if (firstChar != strs[i].charAt(0)) {
                return " ";
            }
        }
        //都遍历完，且没有从return中出去，能走到下面就表示可以找到
        StringBuilder commonPrefix = new StringBuilder();
        //首字母相同
        commonPrefix.append(strs[0].charAt(0));
        //下面开始判断后面的。
        //思路是先找字母，再判断字符串；
        //char
        for (int j = 1; j < minlength; j++) {
            // 字符串数组第一个元素的第J个字符
            char c = strs[0].charAt(j);
            //遍历字符串数组的每个元素
            for (int i = 1; i < strs.length; i++) {
                //如果不等于，直接返回上面得到的那个（首字母复合时的前缀）
                if (c != strs[i].charAt(j)) return commonPrefix.toString();
            }
            //找到就append到里面
            commonPrefix.append(c);
        }
        //然后返回找到的公共前缀
        return commonPrefix.toString();
    }
}

class maxCommonPrefixL11{
    public static void main(String[] args) {
        String[] strs ={"flower","flow","flowyy"};
        L14MaxCommonPrefixSolution mcp = new L14MaxCommonPrefixSolution();

        System.out.println(mcp.maxCommonPrefix(strs));
    }
}
