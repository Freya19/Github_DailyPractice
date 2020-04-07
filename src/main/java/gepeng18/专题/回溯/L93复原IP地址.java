package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.List;

public class L93复原IP地址 {
    List<String> res = new ArrayList<>();
    int deep = 0;
    public void back(String s,List<String> state, int q,int deep){
        if(s.length()-q<1*(4-deep) || s.length()-q>3*(4-deep))
            return;
        else if (s.length()==q){
            StringBuilder stringBuilder = new StringBuilder();
            for(String sub:state)
                stringBuilder.append(sub).append(".");

            res.add(stringBuilder.toString().substring(0,stringBuilder.toString().length()-1));
            return ;
        }

        for(int i=q;i<q+3;i++){
            if(i==s.length())
                return ;
            String substring = s.substring(q, i + 1);
            int tmpNum = Integer.valueOf(substring);
            if(String.valueOf(tmpNum).length()!=i+1-q)
                return;
            if(tmpNum>=0&&tmpNum<=255){
                List<String> tmp = new ArrayList<>(state);
                tmp.add(substring);
                back(s,tmp,i+1,deep+1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> state  = new ArrayList<>();
        back(s,state,0,deep);
        return res;
    }

    public static void main(String[] args) {
        final List<String> strings = new L93复原IP地址().restoreIpAddresses("25525511135");
    }
}
