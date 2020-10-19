package gepeng18.笔试.浦发;

import freya19.practice.算法题和数据结构.找规律.SO3数组中重复的数字;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class 函数库 {
    public static int string2int(String s){
        int length = s.length();
        boolean negative = false;
        int start = 0;
        if (s.charAt(0)=='-'){
            negative = true;
            start = 1;
        }

        int num = 0;
        for (int index=start;index<length;index++){
            num=num*10+s.charAt(index)-'0';
        }
        if (negative)
            num = num*(-1);
        return  num;
    }

    public static int MyIndexOf(String s,char c){
        for (int i = 0;i<s.length();i++)
            if (s.charAt(i) == c) {
                return i;
            }
        return -1;
    }

    public static int MyIndexOf(String s,int start,char c){
        for (int i = start;i<s.length();i++)
            if (s.charAt(i) == c) {
                return i;
            }
        return -1;
    }

    public static String MySubString(String s,int start,int end){
        if (end>s.length())
            end = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0;i<s.length();i++)
            if (i>=start&&i<end) {
                res.append(s.charAt(i));
            }
        return res.toString();
    }


    public static List<Integer> solve(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = -1;
        while (true) {
            int end = MyIndexOf(s, start+1, ',');
            if (end==-1){
                res.add(string2int(MySubString(s,start+1, s.length())));
                break;
            }
            res.add(string2int(MySubString(s,start+1, end)));
            start = end;

        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = solve("1,2,3,-1,-1,5");
        System.out.println(res);
    }
}
