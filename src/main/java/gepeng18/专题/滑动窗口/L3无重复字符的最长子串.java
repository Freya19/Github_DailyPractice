package gepeng18.专题.滑动窗口;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class L3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        //保证字符串一定无重复字符
        int l = 0, r = -1;
        int res = 0;

        while( l < s.length() ){

            if(r+1<s.length()&&freq[s.charAt(r+1)] == 0 ){
                r++;
                freq[s.charAt(r)] ++;
            }
            else{
                freq[s.charAt(l)] --;
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }


}




