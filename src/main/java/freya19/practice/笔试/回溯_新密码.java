package freya19.practice.笔试;
import java.util.HashSet;

/** sougou -3 ：“123” —— 首位0-9，其次的位数是前一位 + 原密码当前位置元素之和算数平均值*/
public class 回溯_新密码 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回生成的新密码个数
     *
     * @param password string字符串 密码的数组字符串（长度小于50），例如 12345
     * @return long长整型
     */

    HashSet<String> hashSet = new HashSet<>();

    public void doFunc(String pswd, int i, String tmpNewPswd) {

        if (tmpNewPswd.length() == pswd.length()) {
            hashSet.add((tmpNewPswd));
            return; }

        int sum = Integer.parseInt(String.valueOf(pswd.charAt(i))) + Integer.parseInt(String.valueOf(tmpNewPswd.charAt(i - 1)));
        if (sum % 2 == 1) {
            //和为奇数时，两种情况：向上和向下取整
            doFunc(pswd, i + 1, tmpNewPswd + String.valueOf(sum / 2 + 1));
            doFunc(pswd, i + 1, tmpNewPswd + String.valueOf(sum / 2));
        } else {
            // 和为偶数，就一种情况
            doFunc(pswd, i + 1, tmpNewPswd + String.valueOf(sum / 2));
        }
    }

    public long getPasswordCount(String password) {
        // write code here
        for (int i = 0; i < 10; i++) {
            doFunc(password, 1, String.valueOf(i));
        }
        hashSet.remove(password);
        return hashSet.size();
    }
}
