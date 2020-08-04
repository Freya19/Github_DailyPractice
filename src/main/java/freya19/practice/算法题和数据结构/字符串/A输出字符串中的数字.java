package freya19.practice.算法题和数据结构.字符串;

import java.util.Scanner;

public class A输出字符串中的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        // 6--nm#%@yy-++1bf0d--+11ss---12abc912u
        String newStr=" ";
        for(int i=0;i<str.length();i++){
            if(!isNum(str.charAt(i))&&str.charAt(i)!='-'&&str.charAt(i)!='+'){
//                sb.append('#');
                newStr = str.replace(str.charAt(i),'#');
//            }else {
//                sb.append(str.charAt(i));
            }
        }

        // 6--#######-++1##0#--+11##---12###912#
        for(int i=0;i<sb.length();i++){
            String[] strs = newStr.split("-");
        }

        

        System.out.println(sb.toString());

    }

    private static boolean isNum(char c){
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        String s = "6--nm#%@yy-++1bf0d--+11ss---12abc912u";
//        String[] strs = s.split("-");
//        int cnt =0;
//        for(String ss:strs){
////            if(ss.equals(" ")){
////                cnt++;
////            }
//            System.out.println(ss);
//        }
//    }
}
