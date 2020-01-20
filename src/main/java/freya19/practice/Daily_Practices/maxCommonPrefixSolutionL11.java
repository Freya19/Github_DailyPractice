package freya19.practice.Daily_Practices;

public class maxCommonPrefixSolutionL11 {
    public String maxCommonPrefix(String [] strs) {
        if (strs.length == 0) return " ";

        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minlength = Math.min(minlength, strs[i].length());
        }
        if (minlength == 0) return " ";

        char firstChar = strs[0].charAt(0);
        for (int i = 1; i < strs.length; i++) { //这个循环用于判断第i个位置的字符是否相同，相同的话，继续执行，
            //直到字符数组里所有的字符串都被遍历了，都相等，就从循环出来；否则，返回空字符串。
            if (firstChar != strs[i].charAt(0)) {
                return " ";
            }
        }
        //都遍历完，且没有从return中出去，能走到下面就表示可以找到
        StringBuilder commonPrefix = new StringBuilder();
        commonPrefix.append(strs[0].charAt(0)); //首字母相同
        //下面开始判断后面的。
        //思路是先找字母，再判断字符串；
        for (int j = 1; j < minlength; j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (c != strs[i].charAt(j)) return commonPrefix.toString();
            }
            commonPrefix.append(c);
        }
        return commonPrefix.toString();
    }
}

class maxCommonPrefixL11{
    public static void main(String[] args) {
        String[] strs ={"flower","flow","flowyy"};
        maxCommonPrefixSolutionL11 mcp = new maxCommonPrefixSolutionL11();

        System.out.println(mcp.maxCommonPrefix(strs));
    }
}
