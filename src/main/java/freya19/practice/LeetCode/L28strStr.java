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
package freya19.practice.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class L28strStr {
    public int strStr(String haystack, String needle){
//        if(haystack==null || haystack.length()<needle.length()) return -1; // 这里有个疑问，就是 haystack如果空的话会咋样
        if(needle==null) {
            return 0;
        }

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
        //队列里没有任何数据，就表示没有这样的子串，就是没有找到了
        if(q.size()==0) {
            return -1;
        }
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

        L28strStr ss = new L28strStr();

        System.out.println(ss.strStr(s1,s2));
        System.out.println(ss.strStr(s3,s4));
        System.out.println(ss.strStr(s5,s6));
        System.out.println(ss.strStr(s7,s8));  //输出仍然是 -1 ，这里是自动把haystack为空也处理了吗？？？
        System.out.println(ss.strStr(s9,s10)); // 输出是0 。。。  这是为啥嘞？
    }
}


/*
有关队列：Queue
队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。

示例：
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
    }
}
一些方法的区别：
offer，add 区别：
一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。
简言之，offer方法不报异常，不处理异常。

poll，remove 区别：
remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，
但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。

peek，element区别：
element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
 */