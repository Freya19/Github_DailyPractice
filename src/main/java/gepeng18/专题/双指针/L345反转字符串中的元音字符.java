package gepeng18.专题.双指针;

import javax.xml.stream.events.Characters;
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
public class L345反转字符串中的元音字符 {

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
        int right = s.length()-1;
        while(left<right){
            if(!yuan.contains(s.charAt(left))){
                left++;
            }else if(!yuan.contains(s.charAt(right))) {
                right--;
            }else{
                sb.replace(right,right+1,String.valueOf(s.charAt(left)));
                sb.replace(left,left+1,String.valueOf(s.charAt(right)));
                right--;
                left++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final String hello = new L345反转字符串中的元音字符().reverseVowels("hello");
        System.out.println(hello);
    }
}
