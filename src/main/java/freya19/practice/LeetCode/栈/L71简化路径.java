package freya19.practice.LeetCode.栈;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 */
public class L71简化路径 {
    public String simplifyPath(String path) {

        //首先定义栈用来存储路径信息
        Stack<String> stack = new Stack<>();

        //将path按/分隔，存入字符数组中
        String[] str = path.split("/");

        //依次遍历字符数组的内容
        //首先如果是".."且栈内有元素
        for (String s : str) {
            //注意！！！！：增强for循环，这种两个if的判断必须分开写？
            //这里用到增强型 for 循环不能同时判断，需要再次判空
            // 而普通 for 循环则可写成  ( !stack.isEmpty() && s.equals("..") ) —— 这样写的结果是c..
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(s) && !"".equals(s)) {
                //不是"."也不是""，则直接入栈
                stack.push(s);
            }
        }

        //如果栈为空，就直接返回"/"
        if (stack.isEmpty()) {
            return "/";
        }

        //如果栈非空，则用StringBuilder来存储栈中的值（快些），最后返回
        StringBuilder res = new StringBuilder();
        //用for和stack.get()是为了避免pop时路径出栈反过来了
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }


        return res.toString();
    }

    public static void main(String[] args) {
        String s = "/a/../../b/../c//.//";
        L71简化路径 l71 = new L71简化路径();
        String s1 = l71.simplifyPath(s);
        System.out.println(s1);
    }

}
