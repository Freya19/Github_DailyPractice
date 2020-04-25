package gepeng18.笔试.腾讯2020校园招聘;

import com.sun.jmx.snmp.internal.SnmpSubSystem;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.Stack;

/**
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 * 输入描述:
 * 输入第一行包含一个字符串s，代表压缩后的字符串。
 * S的长度<=1000;
 * S仅包含大写字母、[、]、|;
 * 解压后的字符串长度不超过100000;
 * 压缩递归层数不超过10层;
 * 输出描述:
 * 输出一个字符串，代表解压后的字符串。
 * 输入例子1:
 * HG[3|B[2|CA]]F
 * 输出例子1:
 * HGBCACABCACABCACAF
 * 例子说明1:
 * HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 */
public class 压缩算法 {

    //解析s，并返回
    public String solution( String s) {
        int index=0;
        int indexofleft = s.indexOf('[');
        int indexofshu = s.indexOf('|');
        int indexofright = s.lastIndexOf(']');
        if(indexofleft==-1)
            return s;
        int times = Integer.valueOf(s.substring(indexofleft+1,indexofshu));
        StringBuilder result = new StringBuilder();
        result.append(s.substring(0,indexofleft));
        String sub = solution(s.substring(indexofshu + 1, indexofright));
        for(int i=0;i<times;i++)
            result.append(sub);
        result.append(s.substring(indexofright+1));
        return result.toString();
    }

    public String input(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void main(String[] args) {
        final 压缩算法 instance = new 压缩算法();
        String input = instance.input();

        System.out.println(instance.solution(input));
    }
}

