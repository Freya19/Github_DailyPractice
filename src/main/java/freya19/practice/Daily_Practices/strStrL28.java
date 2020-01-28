/*
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找
出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2

示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1

说明:
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
package freya19.practice.Daily_Practices;

import java.util.LinkedList;
import java.util.Queue;

public class strStrL28 {
    public int strStr(String haystack, String needle){
//        if(haystack==null || haystack.length()<needle.length()) return -2; // 这里有个疑问，就是 haystack如果地空的话会咋样
        if(needle==null) return 0;

        Queue<Integer> q = new LinkedList<Integer>();
//        for(int i=0;i<haystack.length();i++){             // 这样是错的，因为不能控制字符不等的时候 needle的索引不动
//            for(int j=0;j<needle.length();j++){
//                if(haystack.charAt(i)==needle.charAt(j)){
//                    q.offer(i);
//                }else{
//                    i++;
//                }
//            }
//        }return q.element();

        int i = 0,j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                    q.offer(i);
                    i++;
                    j++;
                }else{
                    i++;
                }
        }
        if(q.size()==0) return -1; //队列里没有任何数据，就表示没有这样的子串，就是没有找到了
        return q.element();
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";

        String s3= "aaaaa";
        String s4 = "bba";

        String s5= "aaaa";
        String s6 = "";

        String s7= "";
        String s8 = "";

        String s9= "aaa";
        String s10 = "aaabbb";

        strStrL28 ss = new strStrL28();

        System.out.println(ss.strStr(s1,s2));
        System.out.println(ss.strStr(s3,s4));
        System.out.println(ss.strStr(s5,s6));
        System.out.println(ss.strStr(s7,s8));  //输出仍然是 -1 ，这里是自动把haystack为空也处理了吗？？？
        System.out.println(ss.strStr(s9,s10)); // 输出是0 。。。  这是为啥嘞？
    }
}
