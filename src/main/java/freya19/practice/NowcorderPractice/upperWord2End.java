package freya19.practice.NowcorderPractice;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 32M，其他语言64M

把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。

输入描述:输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
输出描述:对于每组数据，输出移位后的字符串。

输入例子1：AkleBiCeilD
输出例子1:kleieilABCD

 */
public class upperWord2End {
    public String upperWordToEnd(String src){
//        char[] c = src.toCharArray();
        StringBuilder dstU = new StringBuilder();
        StringBuilder dstL = new StringBuilder();

        if(src==null&&src.length() ==0) return "0";

        for(int i=0;i<src.length();i++){
            char c = src.charAt(i);
            if(c >=65 && c <= 90){ //大写（ASCII码）
                dstU.append(c); //大写加到大写的dstU中
            }
            else if(c <65 || c >90)  dstL.append(c);//小写的只能放到这里
        }

        for(int j =0;j<dstU.length();j++){
            char c = src.charAt(j);
            dstL.append(c);
        }

        String dst = dstL.toString();
        return dst;
    }

    public static void main(String[] args) {
        String s = "AbbbbCDeeFggH";
        String s1 = "";

        upperWord2End uwe = new upperWord2End();
//        System.out.println(uwe.upperWordToEnd(s));
//        System.out.println(uwe.upperWordToEnd(s1));


    }
}
