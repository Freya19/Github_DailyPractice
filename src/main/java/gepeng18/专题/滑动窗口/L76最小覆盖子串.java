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
    public String minWindow(String s, String t) {
        int []freqT = new int[256];

        for (int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i)] ++;
        }

        int []freqS = new int[256];
        int count = 0; //有多少个元素得到判断
        int minLength = s.length()+1;
        int startIndex = -1;

        int l = 0, r = -1;
        while(l < s.length()){
            if(r+1<s.length()&&count<t.length()){
                r++;
                freqS[s.charAt(r)]++;
                // <=表明还没超过，没有超过则count++
                if(freqS[s.charAt(r)]<=freqT[s.charAt(r)])
                    count++;
            } else{
                freqS[s.charAt(l)]--;
                // >的情况下就不要减了
                if(freqS[s.charAt(l)]<freqT[s.charAt(l)])
                    count--;
                l++;
            }

            if(count==t.length()&&(r-l+1)<minLength){
                minLength = r-l+1;
                startIndex = l;
            }

        }

        if(startIndex!=-1)
            return s.substring(startIndex,startIndex+minLength);
        else
            return  "";
    }

    public static void main(String[] args) {
        System.out.println(new L76最小覆盖子串().minWindow("aba", "b"));
    }
}
