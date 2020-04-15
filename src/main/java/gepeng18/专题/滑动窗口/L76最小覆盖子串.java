package gepeng18.专题.滑动窗口;

import java.util.ArrayList;
import java.util.List;

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
                if(freqS[s.charAt(r)]<=freqT[s.charAt(r)])
                    count++;
            }
            else{
                freqS[s.charAt(l)]--;
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
