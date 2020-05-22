package gepeng18.专题.双指针;

import java.util.*;

public class L524最长子序列 {

    public String findLongestWord(String s, List<String> d) {
        //如果答案不止一个，返回长度最长且字典顺序最小的字符串
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                    if(o2.length() != o1.length())
                        return o2.length() - o1.length();
                    else
                        return o1.compareTo(o2);
            }
        });

        for (String eachString : d) {
            //eachString 是s的子序列
            if (isSubSeq(s, eachString))
                return eachString;
        }
        return "";
    }

    private boolean isSubSeq(String s, String eachString) {
        int sIndex = 0;
        int eIndex = 0;
        while (sIndex < s.length() && eIndex < eachString.length()) {
            if (s.charAt(sIndex) == eachString.charAt(eIndex)) {
                sIndex++;
                eIndex++;
            } else
                sIndex++;
        }
        if (eIndex == eachString.length())
            return true;
        else
            return false;


    }

    public static void main(String[] args) {
        String res = new L524最长子序列().findLongestWord("abpcplea",new ArrayList<>(Arrays.asList("ale","apple","monkey","plea")));
        System.out.println(res);
    }
}

