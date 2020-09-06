package gepeng18.专题.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果没有覆盖，则右指针前移
 * 如果覆盖了，  则左指针前移
 *
 * 每次循环，判断是否覆盖和是否最小
 */
public class L76最小覆盖子串 {
    public String minWindow(String str1, String str2) {
        int []str2char = new int[256];

        for (int i = 0; i < str2.length(); i++) {
            str2char[str2.charAt(i)] ++;
        }

        int []str1char = new int[256];
        int count = 0; //有多少个元素得到判断
        int minLength = str1.length()+1;
        int startIndex = -1;

        int l = 0, r = -1;
        while(l < str1.length()){
            if(r+1<str1.length()&&count<str2.length()){
                r++;
                str1char[str1.charAt(r)]++;
                // <=表明还没超过，没有超过则count++
                if(str1char[str1.charAt(r)]<=str2char[str1.charAt(r)])
                    count++;
            } else{
                str1char[str1.charAt(l)]--;
                // >的情况下就不要减了
                if(str1char[str1.charAt(l)]<str2char[str1.charAt(l)])
                    count--;
                l++;
            }

            if(count==str2.length()&&(r-l+1)<minLength){
                minLength = r-l+1;
                startIndex = l;
            }

        }

        if(startIndex!=-1)
            return str1.substring(startIndex,startIndex+minLength);
        else
            return  "";
    }

    public static void main(String[] args) {
        System.out.println(new L76最小覆盖子串().minWindow("aba", "b"));
    }
}
