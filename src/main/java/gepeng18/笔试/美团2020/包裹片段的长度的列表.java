package gepeng18.笔试.美团2020;

import java.util.ArrayList;
import java.util.Scanner;

public class 包裹片段的长度的列表 {
    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int l = 0, r = -1, len = s.length();
        int curMaxIndex = s.lastIndexOf(s.charAt(l));
        while (l < len) {
            if(r+1<s.length()&&r+1<=curMaxIndex){
                r++;
                curMaxIndex = Math.max(curMaxIndex,s.lastIndexOf(s.charAt(r)));
            }
            else{
                res.add(r-l+1);
                l = r+1;
                // 这里也是测试出来的，因为访问了r+1，所以可能越界，之前的滑动窗口都没r+1这样做过
                if(l<len)
                    curMaxIndex = s.lastIndexOf(s.charAt(l));
            }
        }
        for (int i=0;i<res.size();i++)
            System.out.print(res.get(i)+" ");
    }
}
