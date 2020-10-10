package gepeng18.专题.双指针;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 */
public class L345反转字符串中的元音字符2 {

    public String reverseVowels(String s) {
        final StringBuilder sb = new StringBuilder(s);
        Set<Character> yuan = new HashSet<>();
        yuan.add('a');
        yuan.add('o');
        yuan.add('e');
        yuan.add('i');
        yuan.add('u');
        yuan.add('A');
        yuan.add('O');
        yuan.add('E');
        yuan.add('I');
        yuan.add('U');


        int left = 0;
        int right = sb.length()-1;
        while(left<right){
           while (left<right&&!yuan.contains(sb.charAt(right))){
               right--;
           }
            while (left<right&&!yuan.contains(sb.charAt(left))){
                left++;
            }
            if (left<right){
                char tmp = sb.charAt(right);
                sb.setCharAt(right,sb.charAt(left));
                sb.setCharAt(left,tmp);
                right--;
                left++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final String hello = new L345反转字符串中的元音字符2().reverseVowels("hello");
        System.out.println(hello);
    }
}
