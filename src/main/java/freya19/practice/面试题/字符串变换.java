//package freya19.practice.面试题;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * 给出一个数字组成的字符串s及n个数字变换(a,b)
// * 每个变换(a,b)是将字符串里面的数字a变成数字b，
// * 如果字符串里面不存在数字a，则不做变换
// * 输出全部操作完成后的字符串
// */
//public class 字符串变换 {
//    public static String solve(String s,char [][] transfer){
//        HashMap<Character,ArrayList<Integer>> hashMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (hashMap.get(s.charAt(i))!=null){
//                hashMap.get(s.charAt(i)).add(i);
//            }else{
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(i);
//                hashMap.put(s.charAt(i),list);
//            }
//        }
//
//        for (int i =0;i<transfer.length;i++){
//            int src = transfer[i][0];
//            int dst = transfer[i][1];
//            ArrayList<Integer> srcList = hashMap.get(src);
//            ArrayList<Integer> dstList = hashMap.get(src);
//            dstList.addAll(srcList);
//            hashMap.remove(src);
//        }
//        char[] chars = new char[s.length()];
//        for (Map.Entry<Character, ArrayList<Integer>> map : hashMap.entrySet()) {
//
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        int times = input.nextInt();
//        int[][] tranfer = new int[times][2];
//        for (int i =0;i<times;i++){
//            tranfer[i][ 0 ] = input.nextInt();
//            tranfer[i][ 1 ] = input.nextInt();
//        }
//
//        String res = solve(s, tranfer);
//        System.out.println(res);
//
//    }
//
//}
