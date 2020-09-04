package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 面试题38字符串的排列 {

    private List<String> res = new ArrayList<>();

    private Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        back("", s);
        return res.toArray(new String[0]);
    }

    public void back(String state, String s) {
        if (set.contains(state))
            return;
        else if (s.length() == 0) {
            res.add(state);
            set.add(state);
            return;
        }

        for(int i=0;i<s.length();i++){
            back(state+s.charAt(i),s.substring(0,i)+s.substring(i+1));
        }
    }

    public static void main(String[] args) {
        final String[] abcs = new 面试题38字符串的排列().permutation("abc");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }
}
