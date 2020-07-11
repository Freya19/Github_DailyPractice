/*
外观数列：是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
1、11、   21、    1211、        111221
   1个1、 两个1   1个2 1个1     1个1 1个2 两个1

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
注意：整数序列中的每一项将表示为一个字符串。

示例 1:
    输入: 1
    输出: "1"
    解释：这是一个基本样例。

示例 2:
    输入: 4
    输出: "1211"
    解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，
    也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。
    所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。

 */
package freya19.practice.题目分组;

public class L38CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return " ";
        String str = "1"; //第一个字符串

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(); // 这个sb要放在n循环内，为的是每次遍历n的时候，都是空的sb，这样才能得到最后的描述字符
            int count = 0; //几个  同上
            char prev = '.'; //数字 同上
            for (int index = 0; index < str.length(); index++) {
                if (str.charAt(index) == prev || prev == '.') {
                    count++;
                } else {
                    sb.append(count + Character.toString(prev));
                    count = 1;
                }
                prev = str.charAt(index); //将当前字符（数字）赋给 prev
            }
            // 当前字符长度的次循环都走完了
            sb.append(count + Character.toString(prev)); //将相同字符的个数和对应数字添加到sb中
            str = sb.toString(); //描述字符作为n循环的新字符串；
        }
        //最终返回str
        return str;
    }

/*
    1      2        3             4                 n
1、11、   21、    1211、        111221              str
   1个1、 两个1   1个2 1个1     1个1 1个2 两个1     外观描述
*/
    public static void main(String[] args) {
        L38CountAndSay cas = new L38CountAndSay();
        System.out.println(cas.countAndSay(5));
    }

}
