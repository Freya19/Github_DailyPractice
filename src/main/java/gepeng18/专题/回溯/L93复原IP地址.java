package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class L93复原IP地址 {
    List<String> res = new ArrayList<>();
    int deep = 0;

    public List<String> restoreIpAddresses(String s) {
        List<String> state  = new ArrayList<>();
        back(s,state,0,deep);
        return res;
    }

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
            //因为这里不是以for length的形式，所以会有越界的情况
            if(i==s.length())
                return ;
            //将以0开头的去掉，IP地址没有字段是以0开头的，所以一旦检测到以0开头，则表明这样分不对
            //那为什么不continue而是return呢？因为这里是取q i+1所以，一旦检测到以0开头，那表明q处是0，
            //这样的话后面都没必要判断了，肯定都不符合条件，回退到上一步
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

    public static void main(String[] args) {
        final List<String> strings = new L93复原IP地址().restoreIpAddresses("25525511135");
    }
}
