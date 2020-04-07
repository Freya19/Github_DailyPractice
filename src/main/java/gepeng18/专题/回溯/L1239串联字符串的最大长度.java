package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L1239串联字符串的最大长度 {
    List<String> arr = new ArrayList<>();
    String state = "";
    int max = 0;
    void back(List<String> arr,String state,int q)
    {
        if(state.length()>max)
            max = state.length();
        for(int i=q;i<arr.size();i++)
        {
            Set<Character> s = new HashSet();
            for(int j=0;j<state.length();j++)
                s.add(state.charAt(j));
            for(int j=0;j<arr.get(i).length();j++)
                s.add(arr.get(i).charAt(j));
            if(state.length()+arr.get(i).length() == s.size())
                back(arr,state+arr.get(i),i+1);
        }

    }
    public int maxLength(List<String> arr) {
        back(arr,state,0);
        return max;
    }

}
