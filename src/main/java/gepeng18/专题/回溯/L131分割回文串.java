package gepeng18.专题.回溯;

import java.util.ArrayList;
import java.util.List;

public class L131分割回文串 {
    //定义全局变量保存最终结果
    List<List<String>> res = new ArrayList<>();


    // 检查字符串列表是否为回文
    private boolean checkPalindrome(String str)
    {
        for(int i=0;i<str.length()/2;i++) {
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }

    public void back(String str,List<String> state ){
        //状态满足最终要求
        if(str.length()==0){
            // 加入结果
            res.add(state);
            return;
        }

        // 主要递归过程，一般是带有 循环体 或者 条件体
        for(int i=0;i<str.length();i++){
            if(checkPalindrome(str.substring(0,i+1))){
                ArrayList<String> tmp = new ArrayList<>(state);
                tmp.add(str.substring(0,i+1));
                back(str.substring(i+1),tmp);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<String> state = new ArrayList<>();     //定义状态变量保存当前状态
        back(s,state);
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> aab = new L131分割回文串().partition("abc");
        for (int i = 0; i < aab.size(); i++) {
            System.out.println(aab.get(i));
        }
    }

}
